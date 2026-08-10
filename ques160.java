public class ques160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp=headA;
        ListNode tempB=headB;
        int sizeA=0;
        int sizeB=0;
        while(temp!=null){
            sizeA++;
            temp=temp.next;
        }
        while(tempB!=null){
            sizeB++;
            tempB=tempB.next;
        }
        temp=headA;
        tempB=headB;
        if(sizeA>sizeB){
            int steps=sizeA-sizeB;
            for(int i=1;i<=steps;i++){
                temp=temp.next;
            }
        }
        else{
            int steps=sizeB-sizeA;
            for(int i=1;i<=steps;i++){
                tempB=tempB.next;
            }
        }
        while(temp!=tempB){
            temp=temp.next;
            tempB=tempB.next;
        }
        return temp;


    }
}
