// See https://aka.ms/new-console-template for more information
//char for a single alphanumeric character
char c = 'a';
Console.WriteLine(c);
Console.WriteLine($"char  : {char.MinValue} to {char.MaxValue}");

//string for words, phrases, or any alphanumeric data for presentation, not calculation
string str = "Hello!1";
Console.WriteLine(str);

//int for a whole numbe
int x = 12, y = -15; int z = 00;
Console.Write(x + " " + y + " " + z + "\n");

int age = 26;
Console.WriteLine(age);

long mobile = 859674894578;
Console.WriteLine(mobile);

Console.WriteLine("Signed integral types:");

Console.WriteLine($"sbyte  : {sbyte.MinValue} to {sbyte.MaxValue}"); //-128 to 127
Console.WriteLine($"short  : {short.MinValue} to {short.MaxValue}"); //-32768 to 32767
Console.WriteLine($"int    : {int.MinValue} to {int.MaxValue}"); // -2147483648 to 2147483647
Console.WriteLine($"long   : {long.MinValue} to {long.MaxValue}"); //-9223372036854775808 to 9223372036854775807

Console.WriteLine("");
Console.WriteLine("Unsigned integral types:");

Console.WriteLine($"byte   : {byte.MinValue} to {byte.MaxValue}"); // 0 to 255
Console.WriteLine($"ushort : {ushort.MinValue} to {ushort.MaxValue}"); // 0 to 65535
Console.WriteLine($"uint   : {uint.MinValue} to {uint.MaxValue}"); // 0 to 4294967295
Console.WriteLine($"ulong  : {ulong.MinValue} to {ulong.MaxValue}"); //0 to 18446744073709551615

Console.WriteLine();
//decimal for a number with a fractional component.
//Precision is the number of value places stored after the decimal point.
//float and double values are stored internally in a binary (base 2) format, while decimal is stored in a decimal (base 10) format. 
float salary = 23.12F;
Console.WriteLine(salary);

double negative = -55.23D;
Console.WriteLine(negative);

decimal money = 25.12M;
Console.WriteLine(money);

Console.WriteLine("");
Console.WriteLine("Floating point types:");
Console.WriteLine($"float  : {float.MinValue} to {float.MaxValue} (with ~6-9 digits of precision)"); // -3.402823E+38 to 3.402823E+38
Console.WriteLine($"double : {double.MinValue} to {double.MaxValue} (with ~15-17 digits of precision)"); // -1.79769313486232E+308 to 1.79769313486232E+308
Console.WriteLine($"decimal: {decimal.MinValue} to {decimal.MaxValue} (with 28-29 digits of precision)"); // -79228162514264337593543950335 to 79228162514264337593543950335

Console.WriteLine("\n0.1+0.2 == 0.3? " + (0.1 + 0.2 == 0.3));

//bool for a true/false value
bool b = false;
Console.WriteLine(34.40M);

Console.WriteLine(5 / 10);

int value1 = 11;
decimal value2 = 6.2m;
float value3 = 4.3f;

// Your code here to set result1
// Hint: You need to round the result to nearest integer (don't just truncate)
int result1 = Convert.ToInt32(value1 / value2);
Console.WriteLine($"Divide value1 by value2, display the result as an int: {result1}");

// Your code here to set result2
decimal result2 = value2 / (decimal)value3;
Console.WriteLine($"Divide value2 by value3, display the result as a decimal: {result2}");

// Your code here to set result3
float result3 = value3 / value1;
Console.WriteLine($"Divide value3 by value1, display the result as a float: {result3}");

Console.WriteLine("\nPress Enter to continue!");
Console.ReadKey();
