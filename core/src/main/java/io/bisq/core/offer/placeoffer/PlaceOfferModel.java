/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bisq.core.offer.placeoffer;

import io.bisq.common.taskrunner.Model;
import io.bisq.core.btc.wallet.BsqWalletService;
import io.bisq.core.btc.wallet.BtcWalletService;
import io.bisq.core.btc.wallet.TradeWalletService;
import io.bisq.core.offer.Offer;
import io.bisq.core.offer.OfferBookService;
import io.bisq.core.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.Transaction;

@Slf4j
@Getter
public class PlaceOfferModel implements Model {
    // Immutable
    private final Offer offer;
    private final Coin reservedFundsForOffer;
    private final boolean useSavingsWallet;
    private final BtcWalletService walletService;
    private final TradeWalletService tradeWalletService;
    private final BsqWalletService bsqWalletService;
    private final OfferBookService offerBookService;
    private final User user;

    // Mutable
    @Setter
    private boolean offerAddedToOfferBook;
    @Setter
    private Transaction transaction;

    public PlaceOfferModel(Offer offer,
                           Coin reservedFundsForOffer,
                           boolean useSavingsWallet,
                           BtcWalletService walletService,
                           TradeWalletService tradeWalletService,
                           BsqWalletService bsqWalletService,
                           OfferBookService offerBookService,
                           User user) {
        this.offer = offer;
        this.reservedFundsForOffer = reservedFundsForOffer;
        this.useSavingsWallet = useSavingsWallet;
        this.walletService = walletService;
        this.tradeWalletService = tradeWalletService;
        this.bsqWalletService = bsqWalletService;
        this.offerBookService = offerBookService;
        this.user = user;
    }

    @Override
    public void persist() {
    }

    @Override
    public void onComplete() {
    }
}
