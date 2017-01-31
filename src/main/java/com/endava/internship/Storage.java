package com.endava.internship;

import java.util.Set;
import java.util.stream.Collectors;

public class Storage {

    private static Set<String> storage;

    public static Set<String> getStorage() {
        return storage;
    }

    public static void setStorage(Set<String> storage) {
        Storage.storage = storage;
    }

    public static Set<String> addToStorage(String newMessage) throws Exception{
        storage.add(newMessage);
        setStorage(storage.stream().limit(storage.size()).collect(Collectors.toSet()));
        return storage;
    }

    public static void deleteFromStorage(String message) {
        if(storage.contains(message))
            storage.remove(message);
    }
}
