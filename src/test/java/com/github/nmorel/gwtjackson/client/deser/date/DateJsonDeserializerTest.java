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

package com.github.nmorel.gwtjackson.client.deser.date;

import java.util.Date;

import com.github.nmorel.gwtjackson.client.deser.AbstractJsonDeserializerTest;
import com.github.nmorel.gwtjackson.client.deser.BaseDateJsonDeserializer.DateJsonDeserializer;

/**
 * @author Nicolas Morel
 */
public class DateJsonDeserializerTest extends AbstractJsonDeserializerTest<Date> {

    @Override
    protected DateJsonDeserializer createDeserializer() {
        return DateJsonDeserializer.getInstance();
    }

    @Override
    public void testDeserializeValue() {
        assertDeserialization( new Date( 1377543971773l ), "1377543971773" );
        assertEquals( getUTCDate( 2012, 8, 18, 15, 45, 56, 543 ), deserialize( "\"2012-08-18T17:45:56.543+02:00\"" ) );
    }
}
