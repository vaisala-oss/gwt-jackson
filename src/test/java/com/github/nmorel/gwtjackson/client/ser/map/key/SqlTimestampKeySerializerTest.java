/*
 * Copyright 2013 Nicolas Morel
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

package com.github.nmorel.gwtjackson.client.ser.map.key;

import java.sql.Timestamp;

import com.github.nmorel.gwtjackson.client.ser.map.key.BaseDateKeySerializer.SqlTimestampKeySerializer;
import com.github.nmorel.gwtjackson.client.utils.DateFormat;

/**
 * @author Nicolas Morel
 */
public class SqlTimestampKeySerializerTest extends AbstractKeySerializerTest<Timestamp> {

    @Override
    protected SqlTimestampKeySerializer createSerializer() {
        return SqlTimestampKeySerializer.getInstance();
    }

    public void testSerializeValue() {
        Timestamp date = new Timestamp(getUTCTime(2012, 8, 18, 12, 45, 56, 543));
        String expected = DateFormat.format( date );
        assertSerialization(expected, date);
    }
}
