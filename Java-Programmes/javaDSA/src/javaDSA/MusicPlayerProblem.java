package javaDSA;

import java.util.Scanner;

/*
 * In this problem, you need to implement the functionality of a music player using doubly linked list!

The functionality of a playlist queue needs to be implemented, i.e., adding a song to the queue, playing the next song, playing the previous song, switching to a song, etc.

You need to complete the following functions:

addSong(int songId): Add the songId to the end of the list
playNext(): Go to the next song in the list
playPrev(): Go to the previous song in the list
switchSong(int songId): Find in the list where this songId is present, go to that song and continue the playlist from there (In playlist 1<->2<->3<->4<->5 if the current song is 4 and function is called for 2, the current song is stopped and now order is 2->3->4->5)
current(): Return the songId of the song currently playing
Assumptions:

playNext function will not be called from the last song
playPrev function will not be called from the first song
The songId provided in switchSong function is always present in the list
The addSong function will not be called for a songId which is already present in the list
The current function will not be called when the list is empty.
Note: Until the next function is called, the current song will automatically be the first songId added in the list.

The problem input is query-based:

1 : An integer songId will be provided with which addSong(songId) will be called
2 : playNext() is called
3 : playPrev() is called
4 : An integer songId will be provided with which switchSong(songId) will be called
5 : current() is called and you need to return the songId for the current song playing

** Input Format
The first line of input will contain a single integer 
N
N, denoting the number of queries.
The next 
N
N lines contain a single or two integers depending on the type of query.
** Output Format
Output a single integer songId on a new line for every time query type is 5.

Sample 1:
Input
16
1 1
1 2
1 3
5
2
5
3
5
1 4
1 5
2
2
4 1
5
2
5
Output
1
2
1
1
2
 */

public class MusicPlayerProblem {

    private static class MyDoublyList {

        private class node {
            int value;
            node next;
            node prev;

            public node(int val) {
                this.value = val;
                this.next = null;
                this.prev = null;
            }
        }

        node head;
        node cur;
        
        // It is suggested to maintain head pointer for the first element of the list and cur pointer for the current song node
        public MyDoublyList(){
            head=null;
            cur=null;
        }

        public void addSong(int songId){
            node newsong = new node(songId);
            // Consider the case when list is empty too
            if(head == null)
            {
                head = newsong;
            }
            else{
                cur = head;
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next = newsong;
                newsong.prev = cur;
            }
            cur = head;
        }

        public void nextSong(){
            if(cur != null){
                cur = cur.next;
            }
        }

        public void prevSong(){
            if(cur != null && cur != head){
                cur = cur.prev;
            }
        }

        public void switchSong(int songId){
            if(head.value == songId){
                cur = head;
            }
            else{
                cur = head;
                while(cur.next.value != songId)
                {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            
        }

        public int current(){
            if(cur != null){
                return cur.value;
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        	System.out.println("Enter 0 to quit\n"
        			+ "1 : An integer songId will be provided with which addSong(songId) will be called\r\n"
        			+ "2 : playNext() is called\r\n"
        			+ "3 : playPrev() is called\r\n"
        			+ "4 : An integer songId will be provided with which switchSong(songId) will be called\r\n"
        			+ "5 : current() is called and you need to return the songId for the current song playing");
			//int n = sc.nextInt();
			MyDoublyList list = new MyDoublyList();
			while(true){
			    int q = sc.nextInt();
			    if(q == 0)
			    	break;
			    else if(q==1){
			        int songId = sc.nextInt();
			        list.addSong(songId);
			    }
			    else if(q==2){
			        list.nextSong();
			    }
			    else if(q==3){
			        list.prevSong();
			    }
			    else if(q==4){
			        int songId = sc.nextInt();
			        list.switchSong(songId);
			    }
			    else{
			        int ans = list.current();
			        System.out.println(ans);
			    }
			    
			}
		}
    }
}
