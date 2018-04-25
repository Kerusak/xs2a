/*
 * Copyright 2018-2018 adorsys GmbH & Co KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.adorsys.aspsp.xs2a.spi.domain.consent;

import de.adorsys.aspsp.xs2a.spi.domain.account.SpiAccountReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpiAccountAccess {
    private List<SpiAccountReference> accounts;
    private List<SpiAccountReference> balances;
    private List<SpiAccountReference> transactions;
    private SpiAccountAccessType availableAccounts;
    private SpiAccountAccessType allPsd2;

    public boolean isNotEmpty(){
        return isEmpty(this.getAccounts())
                   && isEmpty(this.getBalances())
                   && isEmpty(this.getTransactions())
                   && this.getAllPsd2() == null
                   && this.getAvailableAccounts() == null;
    }
}
