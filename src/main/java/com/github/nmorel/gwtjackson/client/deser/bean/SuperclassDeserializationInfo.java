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

package com.github.nmorel.gwtjackson.client.deser.bean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Contains deserialization informations about superclass
 *
 * @author Nicolas Morel
 */
public class SuperclassDeserializationInfo<T> {

    /**
     * if we include type information in the result
     */
    private final boolean includeTypeInfo;

    /**
     * inclusion mechanism
     */
    private final As include;

    /**
     * Name of the property containing information about the subtype
     */
    private final String propertyName;

    private final Map<String, SubtypeDeserializer<? extends T>> subtypeInfoToDeserializer;

    private final Map<Class<? extends T>, SubtypeDeserializer<? extends T>> subtypeClassToDeserializer;

    public SuperclassDeserializationInfo() {
        this( null, null, false );
    }

    public SuperclassDeserializationInfo( As include, String propertyName ) {
        this( include, propertyName, true );
    }

    private SuperclassDeserializationInfo( As include, String propertyName, boolean includeTypeInfo ) {
        this.includeTypeInfo = includeTypeInfo;
        this.include = include;
        this.propertyName = propertyName;
        if ( includeTypeInfo ) {
            this.subtypeInfoToDeserializer = new HashMap<String, SubtypeDeserializer<? extends T>>();
        } else {
            this.subtypeInfoToDeserializer = null;
        }
        this.subtypeClassToDeserializer = new HashMap<Class<? extends T>, SubtypeDeserializer<? extends T>>();
    }

    public <S extends T> SuperclassDeserializationInfo<T> addSubtypeDeserializer( SubtypeDeserializer<S> subtypeDeserializer,
                                                                                  Class<S> clazz, String typeInfo ) {
        if ( includeTypeInfo ) {
            subtypeInfoToDeserializer.put( typeInfo, subtypeDeserializer );
        }
        subtypeClassToDeserializer.put( clazz, subtypeDeserializer );
        return this;
    }

    public boolean isIncludeTypeInfo() {
        return includeTypeInfo;
    }

    public As getInclude() {
        return include;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public SubtypeDeserializer<? extends T> getDeserializer( Class aClass ) {
        return subtypeClassToDeserializer.get( aClass );
    }

    public SubtypeDeserializer<? extends T> getDeserializer( String typeInfo ) {
        return subtypeInfoToDeserializer.get( typeInfo );
    }
}
