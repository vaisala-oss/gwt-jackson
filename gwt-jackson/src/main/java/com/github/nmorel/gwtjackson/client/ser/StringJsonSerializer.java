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

package com.github.nmorel.gwtjackson.client.ser;

import javax.annotation.Nonnull;
import java.io.IOException;

import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.JsonSerializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonWriter;

/**
 * Default {@link JsonSerializer} implementation for {@link String}.
 *
 * @author Nicolas Morel
 */
public class StringJsonSerializer extends JsonSerializer<String> {

    private static final StringJsonSerializer INSTANCE = new StringJsonSerializer();

    /**
     * @return an instance of {@link StringJsonSerializer}
     */
    public static StringJsonSerializer getInstance() {
        return INSTANCE;
    }

    private StringJsonSerializer() { }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull String value, JsonSerializationContext ctx,
                             JsonSerializerParameters params ) throws IOException {
        writer.value( value );
    }
}
