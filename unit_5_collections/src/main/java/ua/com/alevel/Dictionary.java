package ua.com.alevel;

public class Dictionary<K, V> {

    Node<K, V>[] kvNode = new Node[10];

    private static class Node<K, V> {
        int hash;
        K key;
        V value;
    }
}
