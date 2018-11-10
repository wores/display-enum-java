package com.wores.interfaces;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum用のinterface
 * @param <E>
 */
public interface IDisplayEnum<E extends Enum<E> & IDisplayEnum> {

    String getDisplayName();
    Class<E> getDeclaringClass();

    /**
     * displayNameが一致したenumがあればそれを返す
     * @param displayName
     * @return
     */
    default Optional<E> createByDisplayName(String displayName) {
        Class<E> type = getDeclaringClass();
        List<E> constants = Arrays.asList(type.getEnumConstants());
        for (E c : constants) {
            if (StringUtils.equals(c.getDisplayName(), displayName)) {
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    /**
     * @return [key:name,value:displayName]のLinkedHashMapを返す
     */
    default Map<String,String> toMap(){
        return Stream.of(getDeclaringClass().getEnumConstants())
                .collect(Collectors.toMap(
                        E::name,
                        c -> c.getDisplayName(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}


