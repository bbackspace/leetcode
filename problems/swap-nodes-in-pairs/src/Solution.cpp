/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(!head || !head->next)
            return head;
        ListNode *h = new ListNode(0);
        h->next = head;
        ListNode *p, *q, *r;
        p = h;
        q = p->next;
        if(!q)
            return h->next;
        r = q->next;
        while(p && q)
        {
            q->next = r->next;
            r->next = q;
            p->next = r;
            p = q;
            q = p->next;
            if(!q)
                return h->next;
            r = q->next;
            if(!r)
                return h->next;
        }
    }
};

