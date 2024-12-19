// See https://aka.ms/new-console-template for more information
/*
 * Project overview
    You're developing a Student Grading application that automates the calculation of current grades for each student in a class. The parameters for your application are:

    You're given a short list of four students and their five assignment grades.
    Each assignment grade is expressed as an integer value, 0-100, where 100 represents 100% correct.
    Final scores are calculated as an average of the five assignment scores.
    Your application needs to perform basic math operations to calculate the final grades for each student.
    Your application needs to output/display each student’s name and final score.
    Currently, the teachers grade book shows the graded assignments for each student as follows:

    Sophia: 93, 87, 98, 95, 100

    Nicolas: 80, 83, 82, 88, 85

    Zahirah:   84, 96, 73, 85, 79

    Jeong:  90, 92, 98, 100, 97

    The teacher requires that the calculated grades for each student are displayed as follows:
    Student     Grade
    Sophia      94.6  A
    Nicolas     83.6  B
    Zahirah     83.4  B
    Jeong       95.4  A
*/

// initialize variables - graded assignments 
int currentAssignments = 5;

int[] sophia = { 93, 87, 98, 95, 100 };
int sophiaSum = 0;
for (int i = 0; i < sophia.Length; i++)
{
    sophiaSum += sophia[i];
}
decimal sophiaScore = (decimal)sophiaSum/sophia.Length;
//Console.WriteLine($"Sophia\t{sophiaSum}\t{sophiaScore}");

int[] nicolas = {80,83,82,88,85};
int nicolasSum = 0;
for (int i = 0; i < nicolas.Length; i++)
{
    nicolasSum += nicolas[i];
}
decimal nicolasScore = (decimal) nicolasSum / nicolas.Length;
//Console.WriteLine($"Nicolas\t{nicolasSum}\t{nicolasScore}");

int[] zahira = {84,96,73,85,79};
int zahiraSum = 0;
for (int i = 0; i < zahira.Length; i++)
{
    zahiraSum += zahira[i];
}
decimal zahirahScore = (decimal) zahiraSum / zahira.Length;
//Console.WriteLine($"Zahira\t{zahiraSum}\t{zahirahScore}");

int[] jeong = {90,92,98,100,97};
int jeongSum = 0;
for (int i = 0; i < jeong.Length; i++)
{
    jeongSum += jeong[i];
}
decimal jeongScore = (decimal) jeongSum / jeong.Length;
//Console.WriteLine($"jeong\t{jeongSum}\t{jeongScore}");

/*
    97 - 100    A+
    93 - 96     A
    90 - 92     A-
    87 - 89     B+
    83 - 86     B
*/

Console.WriteLine("Student\t\tAverage Marks\tGrade");
Console.WriteLine("Sophia:\t\t" + sophiaScore + "\t\tA");
Console.WriteLine("Nicolas:\t" + nicolasScore + "\t\tB");
Console.WriteLine("Zahirah:\t" + zahirahScore + "\t\tB");
Console.WriteLine("Jeong:\t\t" + jeongScore + "\t\tA");

/*
 Project overview
    You're developing a Student GPA Calculator that will help calculate students' overall Grade Point Average. The parameters for your application are:

    You're given the student's name and class information.
    Each class has a name, the student's grade, and the number of credit hours for that class.
    Your application needs to perform basic math operations to calculate the GPA for the given student.
    Your application needs to output/display the student’s name, class information, and GPA.
    To calculate the GPA:

    Multiply the grade value for a course by the number of credit hours for that course.
    Do this for each course, then add these results together.
    Divide the resulting sum by the total number of credit hours.
    You're provided with the following sample of a student's course information and GPA:

    Student: Sophia Johnson

    Course          Grade   Credit Hours	
    English 101         4       3
    Algebra 101         3       3
    Biology 101         3       4
    Computer Science I  3       4
    Psychology 101      4       3

    Final GPA:          3.35
 */

string studentName = "Sophia Johnson";
string course1Name = "English 101";
string course2Name = "Algebra 101";
string course3Name = "Biology 101";
string course4Name = "Computer Science I";
string course5Name = "Psychology 101";

int course1Credit = 3;
int course2Credit = 3;
int course3Credit = 4;
int course4Credit = 4;
int course5Credit = 3;

int gradeA = 4;
int gradeB = 3;

int course1Grade = gradeA;
int course2Grade = gradeB;
int course3Grade = gradeB;
int course4Grade = gradeB;
int course5Grade = gradeA;

int totalCreditHours = course1Credit + course2Credit + course3Credit + course4Credit + course5Credit;

int totalGradePoints = 0;
totalGradePoints += course1Credit * course1Grade;
totalGradePoints += course2Credit * course2Grade;
totalGradePoints += course3Credit * course3Grade;
totalGradePoints += course4Credit * course4Grade;
totalGradePoints += course5Credit * course5Grade;

Console.WriteLine($"\n\nStudent: {studentName}");
Console.WriteLine("Course\t\t\tGrade\tCredit Hours");
Console.WriteLine($"{course1Name} \t\t{course1Grade} \t{course1Credit}");
Console.WriteLine($"{course2Name} \t\t{course2Grade} \t{course2Credit}");
Console.WriteLine($"{course3Name} \t\t{course3Grade} \t{course3Credit}");
Console.WriteLine($"{course4Name} \t{course4Grade} \t{course4Credit}");
Console.WriteLine($"{course5Name} \t\t{course5Grade} \t{course5Credit}");

decimal gradePointAverage = (decimal)totalGradePoints / totalCreditHours;

int leadingDigit = (int)gradePointAverage;
int firstDigit = (int)(gradePointAverage * 10) % 10;
int secondDigit = (int)(gradePointAverage * 100) % 10;

Console.WriteLine($"\nFinal GPA:\t\t{leadingDigit}.{firstDigit}{secondDigit}");