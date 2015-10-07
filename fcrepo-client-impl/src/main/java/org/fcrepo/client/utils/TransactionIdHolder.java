/**
 * Copyright 2015 DuraSpace, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fcrepo.client.utils;

/**
 * @author gushakov
 */
public final class TransactionIdHolder {

    private TransactionIdHolder() {
        // private constructor for utility class
    }

    private static final ThreadLocal<String> TX_ID_VAR = new ThreadLocal<>();

    /**
     * Gets current transaction id from thread-local store.
     *
     * @return transaction id prefixed with tx: or null
     */
    public static String getCurrentTransactionId() {
        return TX_ID_VAR.get();
    }

    /**
     * Sets new transaction id in thread-local store.
     *
     * @param txId transaction id prefixed with tx:
     */
    public static void setCurrentTransactionId(final String txId) {
        TX_ID_VAR.set(txId);
    }

    /**
     * Removes transaction id from thread-local store.
     */
    public static void removeCurrentTransactionId() {
        TX_ID_VAR.remove();
    }
}
