/*
 * Copyright 2008 Les Hazlewood
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
package org.jsecurity.subject;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @since 0.9
 * @author Les Hazlewood
 */
public interface PrincipalCollection extends Serializable {

    /**
     * Returns a single principal assignable from the specified type, or <tt>null</tt> if there are none of the
     * specified type.
     *
     *  <p>Note that this would return <code>null</code> List always if the corresponding subject has not logged in.</p>
     *
     * @param type the type of the principal that should be returned.
     * @return a principal of the specified type or <tt>null</tt> if there isn't one of the specified type.
     */
    <T> T oneByType(Class<T> type);

    /**
     * Returns all principals assignable from the specified type, or an empty Collection if no principals of that
     * type are contained.
     *
     *  <p>Note that this would return an empty Collection always if the corresponding subject has not logged in.</p>
     *
     * @param type the type of the principals that should be returned.
     * @return a Collection of principals that are assignable from the specified type, or
     * an empty Collection if no principals of this type are associated.
     */
    <T> Collection<T> byType(Class<T> type);

    /**
     * Returns a single Subject's principals retrieved from all configured Realms as a List, or an empty List if
     * there are not any principals.
     *
     *  <p>Note that this would return an empty List always if the corresponding subject has not logged in.</p>
     *
     * @return a single Subject's principals retrieved from all configured Realms as a List.
     */
    List asList();

    /**
     * Returns a single Subject's principals retrieved from all configured Realms as a Set, or an empty Set if there
     * are not any principals.
     *
     *  <p>Note that this would return an empty Set always if the corresponding subject has not logged in.</p>
     *
     * @return a single Subject's principals retrieved from all configured Realms as a Set.
     */
    Set asSet();

    /**
     * Returns a single Subject's principals retrieved from the specified Realm <em>only</em> as a List, or an empty
     * List if there are not any principals from that realm.
     *
     * <p>Note that this would return an empty List always if the corresponding subject has not logged in.</p>
     *
     * @param realmName the name of the Realm from which the principals were retrieved.
     * @return the Subject's principals from the specified Realm only as a List or an empty List if there are not any
     * principals from that realm.
     */
    List asRealmList( String realmName );

    /**
     * Returns a single Subject's principals retrieved from the specified Realm <em>only</em> as a Set, or an empty
     * Set if there are not any principals from that realm.
     *
     * <p>Note that this would return an empty Set always if the corresponding subject has not logged in.</p>
     *
     * @param realmName the name of the Realm from which the principals were retrieved.
     * @return the Subject's principals from the specified Realm only as a Set or an empty Set if there are not any
     * principals from that realm.
     */
    Set asRealmSet( String realmName );

    public boolean isEmpty();

    public void clear();
}
