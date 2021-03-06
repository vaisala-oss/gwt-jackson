/*
 * Copyright 2014 Nicolas Morel
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

package com.github.nmorel.gwtjackson.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.github.nmorel.gwtjackson.client.AbstractConfiguration;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.github.nmorel.gwtjackson.client.ObjectReader;
import com.github.nmorel.gwtjackson.client.ObjectWriter;

/**
 * Annotation used to define mix-in annotations specific to the annotated {@link ObjectMapper},
 * {@link ObjectReader} or {@link ObjectWriter}.
 * <p>This will generate a {@link JsonSerializer} and {@link JsonDeserializer} specific to the
 * annotated mapper. If you can, prefer the definition of your mix-in annotation in an {@link AbstractConfiguration}.</p>
 *
 * @author Nicolas Morel.
 * @version $Id: $
 */
@Target( {ElementType.TYPE} )
@Retention( RetentionPolicy.CLASS )
@JacksonAnnotation
public @interface JsonMixIns {

    /**
     * List of {@link JsonMixIn} annotations
     *
     * @return an array of {@link com.github.nmorel.gwtjackson.client.annotation.JsonMixIns.JsonMixIn} objects.
     */
    public JsonMixIn[] value();

    /**
     * Definition of a mix-in annotation.
     */
    public @interface JsonMixIn {

        /**
         * Class targeted by the mix-in annotation
         *
         * @return the class
         */
        public Class<?> target();

        /**
         * Mix-in class
         *
         * @return the class
         */
        public Class<?> mixIn();
    }
}
