/*
 * * Copyright 2019-2020 github.com/ReflxctionDev
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
package net.spleefx.api

import net.spleefx.api.debug.DebugRedisAccessor
import net.spleefx.api.stats.GameStatsFactory
import net.spleefx.api.util.IncrementingID
import org.springframework.stereotype.Component
import javax.annotation.PreDestroy

@Component
class ShutdownHooks {

    @PreDestroy
    fun saveIDs() = IncrementingID.config.save(Throwable::printStackTrace)

    @PreDestroy
    fun saveGameStats() = GameStatsFactory.save()

    @PreDestroy
    fun saveDebugReports() = DebugRedisAccessor.save()

}