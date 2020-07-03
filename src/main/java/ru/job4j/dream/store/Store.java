package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
    private static final Store INST = new Store();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job", "Job for juniors", "03-02-2019"));
        posts.put(2, new Post(2, "Middle Java Job", "Job for middles", "04-02-2019"));
        posts.put(3, new Post(3, "Senior Java Job", "Job for seniors", "05-02-2019"));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}
