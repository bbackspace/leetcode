struct Node
{
    int key;
    int val;
    Node *prev;
    Node *next;
    Node(int k, int v) : key(k), val(v), prev(NULL), next(NULL) {}
    Node* remove()
    {
        prev->next = next;
        next->prev = prev;
        prev = next = NULL;
    }
    void insert(Node *p)
    {
        p->next = next;
        p->prev = this;
        next = p;
        p->next->prev = p;
    }
};
class LRUCache{
    Node *head;
    Node *tail;
    map<int, Node*> m;
    int cap;
public:
    LRUCache(int capacity) {
        head = new Node(-1, 0);
        tail = new Node(-1, 0);
        head->next = tail;
        tail->prev = head;
        m.clear();
        cap = capacity;
    }
    
    int get(int key) {
        if(m.count(key) == 0)
            return -1;
        Node *p = m[key];
        p->remove();
        head->insert(p);
        return p->val;
    }
    
    void set(int key, int value) {
        Node *p = NULL;
        if(m.count(key) > 0)
        {
            p = m[key];
            p->remove();
            p->val = value;
        }
        else
        {
            p = new Node(key, value);
            m[key] = p;
        }
        head->insert(p);
        if(m.size() > cap)
        {
            p = tail->prev;
            p->remove();
            m.erase(p->key);
            delete p;
        }
    }
};

