package com.cn.alex.hash;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash算法 路由算法决定着究竟该访问集群中的哪台服务器
 */
public class YizhixingHash {
    /**
     * 虚拟节点的数目
     */
    private static final int VIRTUAL_NODES = 5;
    /**
     * 待加入hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    /**
     * 真实节点列表
     */
    private static List<String> realNodes = new LinkedList<String>();
    /**
     * 存放虚拟节点
     */
    private static SortedMap<Integer, String> virtualnodes = new TreeMap();

    static {
        // 把原始节点添加到真实节点服务列表里
        for (String node : servers) {
            realNodes.add(node);

        }
        // 添加虚拟节点列表里
        for (String node : realNodes
                ) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = node + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                virtualnodes.put(hash, virtualNodeName);
            }
        }
    }

    public static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;

    }

    public static String getServer(String node) {
        int hash = getHash(node);
        SortedMap<Integer, String> submap = virtualnodes.tailMap(hash);
        Integer key = submap.firstKey();
        String virtualNode = submap.get(key);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (int i = 0; i < nodes.length; i++){
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
        }

    }

}
