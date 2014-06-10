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

package com.soomla.levelup.events;

import com.soomla.levelup.rewards.BadgeReward;
import com.soomla.levelup.rewards.Reward;

/**
 * This event is fired when a <code>Reward</code> has been given.
 */
public class RewardGivenEvent {

    /**
     * Constructor
     *
     * @param reward the reward that was given
     */
    public RewardGivenEvent(Reward reward) {
        mReward = reward;
        IsBadge = reward instanceof BadgeReward;
    }

    /** Setters and Getters */

    public Reward getReward() {
        return mReward;
    }

    public final boolean IsBadge;

    /** Private Members */

    private Reward mReward;
}