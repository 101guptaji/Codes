using System;
using System.ComponentModel;

namespace FirstConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //char for a single alphanumeric character
            char c = 'a';
            Console.WriteLine(c);
            Console.WriteLine($"char  : {char.MinValue} to {char.MaxValue}");

            //string for words, phrases, or any alphanumeric data for presentation, not calculation
            string str = "Hello!1";
            Console.WriteLine(str);

            //int for a whole numbe
            int x =12, y=-15; int z = 00;
            Console.Write(x+" "+y+" "+z+"\n");

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


            //decimal for a number with a fractional component.
            //Precision is the number of value places stored after the decimal point.
            //float and double values are stored internally in a binary (base 2) format, while decimal is stored in a decimal (base 10) format. 
            float salary = 23.12F;
            Console.WriteLine(salary);
            Console.WriteLine(float.MinValue);
            Console.WriteLine(float.MaxValue);

            double negative = -55.23D;
            Console.WriteLine(negative);
            Console.WriteLine(double.MinValue);
            Console.WriteLine(double.MaxValue);

            decimal money = 25.12M;
            Console.WriteLine(money);
            Console.WriteLine(decimal.MinValue);
            Console.WriteLine(decimal.MaxValue);

            Console.WriteLine("0.1+0.2 == 0.3? "+(0.1 +0.2 == 0.3));

            //bool for a true/false value
            bool b = false;
            Console.WriteLine(34.40M);

            Console.WriteLine(5 / 10);



            Console.WriteLine("\nPress Enter to continue!");
            Console.ReadKey();
        }
    }
}
