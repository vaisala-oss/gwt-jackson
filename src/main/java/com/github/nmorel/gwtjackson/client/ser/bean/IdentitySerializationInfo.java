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

package com.github.nmorel.gwtjackson.client.ser.bean;

import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.JsonSerializer;

/**
 * Contains identity informations for serialization process.
 *
 * @author Nicolas Morel
 */
public abstract class IdentitySerializationInfo<T, I> extends HasSerializer<I, JsonSerializer<I>> {

    /**
     * if we always serialize the bean as an id even for the first encounter.
     */
    private final boolean alwaysAsId;

    /**
     * Name of the property holding the identity
     */
    private final String propertyName;

    protected IdentitySerializationInfo( boolean alwaysAsId, String propertyName ) {
        this.alwaysAsId = alwaysAsId;
        this.propertyName = propertyName;
    }

    public boolean isAlwaysAsId() {
        return alwaysAsId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public abstract ObjectIdSerializer<I> getObjectId( T bean, JsonSerializationContext ctx );
}
