
/**
 * I spent a huge amount of time on the breadth first search and couldnt get it to work with recursion so I just outputed each step in the recursive function until the logic puzzle is solved.
 *   ( Websites used for help are listed at the bottom ) 
 */
public class Missioneries
{
    int rm, rc, lm, lc, status, flag, select;
    public Missioneries()
    {
        rm = rc = 3;
        lm = lc = 0;
        status = flag = select = 0;
    }

    public void display(char spot1, char spot2)
    {
        System.out.println();
        //print # of m on left side
        for(int i = 0; i < lm; i++)
            System.out.print(" M ");
        
        //print # of c on left side
        for (int i = 0; i < lc; i++)
            System.out.print(" C ");
        
        // "fancy graphics with boat that looks like this (  )"
        if (flag == 0) System.out.print(" __________" + "___________(" + spot1 + "," + spot2 + ") "); 
        
        else System.out.print(" (" + spot1 + "," + spot2 + ") __________" + "___________ ");
        
        //print # of m on right side
        for (int i = 0; i < rm; i++)
            System.out.print(" M ");
        
        //print # of c on right side
        for (int i = 0; i < rc; i++)
        System.out.print(" C ");
    }
    
    // successorMethod() method, checks for the completion of the crossing, if successful it returns 0 if not returns 1           
    int successorMethod()
    
    {
        // if lc and lm are 3 then return 0 for 
        // completion of problem 
        if (lc == 3 && lm == 3) 
        return 0; 
        // if the problem is not solved, return 1 
        else 
        return 1;  
    }
    
    // solution() method, is the recursive method 
    void solution()
    {
        // if the successorMethod returns 1 the program continues in solving the problem 
        if (successorMethod() == 1) { 
            // if the flag is zero, display the status of problem 
            if (flag == 0) { 
                // status of the missionaries and cannibals 
                switch (select) {  
                    case 1: 
                    display('C', ' '); 
                    rc++; 
                    break; 
                    
                    case 2: 
                    display('C', 'M'); 
                    rc++; 
                    rm++; 
                    break; 
                } 
                // check the condition count of the missionaries and cannibals 
                if (((rm - 2) >= rc && (lm + 2) >= lc) || (rm - 2) == 0) { 
                    // boat capacity is 2 
                    rm = rm - 2;  
                    select = 1; 
                    display('M', 'M'); 
                    flag = 1; 
                } 
                // check the condition count of the missionaries and cannibals 
                else if ((rc - 2) < rm && (lm == 0 || (lc + 2) <= lm) || rm == 0) 
                {
                    rc = rc - 2;
                    select = 2; 
                    display('C', 'C');
                    flag = 1; 
                } 
                else if ((rc--) <= (rm--) && (lm++) >= (lc++)) 
                {
                    rc = rc - 1;
                    rm = rm - 1;
                    select = 3;
                    display('M', 'C');
                    flag = 1; 
                } 
            } 
            // if the successorMethod returns 1 the program continues in solving the problem 
            else
            {
                switch (select) 
                { 
                    case 1:
                    display('M', 'M');
                    lm = lm + 2;
                    break; 
                    
                    case 2:
                    display('C', 'C');  
                    lc = lc + 2; 
                    break; 
                    
                    case 3:  
                    display('M', 'C'); 
                    lc = lc + 1; 
                    lm = lm + 1; 
                    break; 
                } 
                // check again for the successorMethod if it is one do the following steps 
                if (successorMethod() == 1) 
                { 
                    // if the lc is greater than 1 and lm is zero of rm is zero then set the  values 
                    if (((lc > 1 && lm == 0) || rm == 0)) 
                    { 
                        lc--; 
                        select = 1; 
                        display('C', ' '); 
                        flag = 0; 
                    } 
                    // if the rc + 2 is greater than rm then set the value
                     
                    else if ((rc + 2) > rm) 
                    {  
                        lc--; 
                        lm--;  
                        select = 2; 
                        display('C', 'M'); 
                        flag = 0; 
                    } 
                } 
            } 
            // RECURSION! :)
            solution(); 
        }
    } 
}

//http://forums.codeguru.com/showthread.php?547079-Missionaries-and-Cannibals-Recursion-problem
//https://github.com/brotharon/Missionaries-and-Cannibals/blob/master/cannibals.cpp
//https://www.sep.com/sep-blog/2014/10/20/recursive-breadth-first-traversal/
//http://www.kurzweilai.net/a-formula-for-intelligence-the-recursive-paradigm
//https://www.java-forums.org/new-java/44725-skip-line-between-2-system-out-println-messages.html        
//https://github.com/greendingbat/missionaries-cannibals/blob/master/MissionariesAndCannibalsFinal.java
//https://github.com/x1r15/Missionary
//https://www.chegg.com/homework-help/questions-and-answers/solve-missionaries-cannibals-problem-one-bank-river-three-missionaries-three-cannibals-one-q26853215?trackid=3d662e40&strackid=20c76ca0&ii=14
//https://www.chegg.com/homework-help/missionaries-cannibals-problem-usually-stated-follows-three-chapter-3-problem-9E-solution-9780136042594-exc
//https://www.chegg.com/homework-help/missionaries-cannibals-problem-usually-stated-follows-three-chapter-3-problem-10E-solution-9780136042594-exc
//https://www.chegg.com/homework-help/building-java-programs-4th-edition-chapter-12-problem-1pp-solution-9780134322766?trackid=3d662e40&strackid=20c76ca0&ii=9
//https://www.chegg.com/homework-help/questions-and-answers/write-recursive-program-java-solve-missionaries-cannibals-problem-three-missionaries-three-q12344615



        
                
