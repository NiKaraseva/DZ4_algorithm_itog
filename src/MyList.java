public class MyList {
    Node[] massive = new Node[16];

    public Object put(Integer k, Integer v){
        Node node = new Node();
        node.key = k;
        node.value = v;
        node.hash = node.key.hashCode()%16;
        if (massive[node.hash] != null){
            Node temp = massive[node.hash];
            while (temp != null){
                if(temp.key == k){
                    return temp.value;
                }
                temp = temp.next;
            }
            node.next = massive[node.hash];
        }
        massive[node.hash] = node;
        return null;
    }

    public Object get(Integer k){
        int index = k.hashCode()%16;
        if (massive[index] != null){
            Node temp = massive[index];
            while (temp != null){
                if (temp.key == k){
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }


    public Object replace(Integer k, Integer v){
        int index = k.hashCode()%16;
        if (massive[index] != null){
            Node temp = massive[index];
            while (temp != null){
                if (temp.key == k){
                    Integer x = temp.value;
                    temp.value = v;
                    return x;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public Object remove(Integer k){
        int index = k.hashCode()%16;
        if (massive[index] != null){
            Node temp = massive[index];
            if (temp.key == k && temp.next == null){
                massive[index] = null;
                return temp.value;
            }
            if (temp.key == k && temp.next != null){
                massive[index] = temp.next;
                return temp.value;
            }
            while (temp.next != null){
                if (temp.next.key == k){
                    Integer x = temp.next.value;
                    temp.next = temp.next.next;
                    return x;
                }
                if (temp.next.key == k && temp.next.next == null){
                    Integer x = temp.next.value;
                    temp.next = null;
                    return x;

                }
                temp = temp.next;
            }
        }
        return null;
    }

    public int size(){
        int count = 0;
        for (int i = 0; i < 16; i++){
            if (massive[i] != null){
                Node temp = massive[i];
                while (temp != null){
                    temp = temp.next;
                    count++;
                }
            }
        }
        return count;
    }

    public boolean containsKey(Integer k){
        int index = k.hashCode()%16;
        if (massive[index] != null){
            Node temp = massive[index];
            while (temp != null){
                if (temp.key == k){
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public boolean containsValue(Integer v){
        for (int i = 0; i < 16; i++){
            if (massive[i] != null){
                Node temp = massive[i];
                while (temp != null){
                    if (temp.value == v){
                        return true;
                    }
                    temp = temp.next;
                }
            }
        }
        return false;
    }
}

class Node{
        Integer value, key;
        int hash;
        Node next;

    }

