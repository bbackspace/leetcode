/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* reverse(ListNode* head) {
    ListNode *p = NULL;
    ListNode *q = head;
    while (q != NULL) {
        ListNode *qnext = q -> next;
        q -> next = p;
        p = q;
        q = qnext;

    }
    return p;
}
class Solution {
    void print(string n, ListNode *a) {
        cout << n;
        for (ListNode *i = a; i; i = i -> next) {
            cout << i -> val << "->";
        }
        cout << "NULL\n";
    }
public:
    void reorderList(ListNode* head) {
        if (!head || !head -> next) {
            return ;
        }
        ListNode *slow, *fast;
        for (slow = head, fast = head -> next; fast && fast -> next; slow = slow -> next, fast = fast -> next -> next);
        // slow points at floor((n-1)/2) index node. slow -> next is the node of the latter half (smaller or equal to former half)
        ListNode *sec = slow -> next;
        slow -> next = NULL;
        // print("head", head);
        // print("sec", sec);
        sec = reverse(sec);
        // print("reverse sec", sec);
        //weave
        ListNode *pnext, *qnext;
        for (ListNode *p = head, *q = sec; p && q; p = pnext, q = qnext) {
            pnext = p -> next;
            qnext = q -> next;
            p -> next = q;
            q -> next = pnext;
        }
    }
};


// 1 2 3 4
    
//     1 2 
//     4 3
    
//     1 4 2 3
    
// 1 2 3 4 5
//     1 2 
//     5 4 3
    
//     1 5 2 4 3
    
// 1 2 3 4 5 6
//     1 2 3
//     6 5 4
    
//     1 6 2 5 3 4
