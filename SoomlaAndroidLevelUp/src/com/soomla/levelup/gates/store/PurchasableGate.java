/*
 * Copyright (C) 2012-2014 Soomla Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.soomla.levelup.gates.store;

import com.soomla.SoomlaUtils;
import com.soomla.levelup.data.LUJSONConsts;
import com.soomla.levelup.gates.Gate;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A specific type of <code>Gate</code> that has an associated
 * market item. The gate opens once the item has been purchased.
 * This gate is useful when you want to allow unlocking of certain levels
 * or worlds only if they are purchased.
 * <p/>
 * Created by refaelos on 07/05/14.
 */
public class PurchasableGate extends Gate {


    /**
     * Constructor
     *
     * @param id               see parent
     * @param associatedItemId the ID of the item which will open the gate once purchased
     */
    public PurchasableGate(String id, String associatedItemId) {
        super(id);
        this.mAssociatedItemId = associatedItemId;
    }

    /**
     * Constructor
     * Generates an instance of <code>PurchasableGate</code> from the given <code>JSONObject</code>.
     *
     * @param jsonObject see parent
     * @throws JSONException
     */
    public PurchasableGate(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
        mAssociatedItemId = jsonObject.getString(LUJSONConsts.LU_ASSOCITEMID);
    }

    /**
     * Converts the current <code>PurchasableGate</code> to a <code>JSONObject</code>.
     *
     * @return A <code>JSONObject</code> representation of the current <code>PurchasableGate</code>.
     */
    @Override
    public JSONObject toJSONObject() {
        JSONObject jsonObject = super.toJSONObject();
        try {
            jsonObject.put(LUJSONConsts.LU_ASSOCITEMID, mAssociatedItemId);
        } catch (JSONException e) {
            SoomlaUtils.LogError(TAG, "An error occurred while generating JSON object.");
        }

        return jsonObject;
    }


    /**
     * Private Members
     */

    private static String TAG = "SOOMLA PurchasableGate";

    private String mAssociatedItemId;
}