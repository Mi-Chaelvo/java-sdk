package com.company.contract.RateheightlockDefinition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tdf.rlp.RLP;
import org.tdf.rlp.RLPCodec;
import org.tdf.rlp.RLPElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RateheightlockDeposit {
    @RLP(0)
    private long value;

    public byte[] RLPserialization() {
        return RLPCodec.encode(RateheightlockDeposit.builder()
                .value(this.value).build());
    }

    public boolean RLPdeserialization(byte[] payload) {
        RateheightlockDeposit rateheightlockDeposit = RLPElement.fromEncoded(payload).as(RateheightlockDeposit.class);
        if (rateheightlockDeposit == null) {
            return false;
        }
        this.value = rateheightlockDeposit.getValue();
        return true;
    }
}
