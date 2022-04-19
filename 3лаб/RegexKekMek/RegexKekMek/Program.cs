using System;
using System.Text.RegularExpressions;

namespace RegexKekMek
{
    class Program
    {
        static void Main(string[] args)
        {
            new ParseRegex().ParseExpration();
            new ParseWithStack().ParseExpration();

        }
    }
}
