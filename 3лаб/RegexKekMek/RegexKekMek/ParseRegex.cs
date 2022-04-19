using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace RegexKekMek
{
    class ParseRegex
    {
        public void ParseExpration()
        {
            Regex regex = new Regex(@"y\s*=\s*\(([a-zA-Z]+)\)\s*\(([a-zA-Z]+)\)\s*\+\s*([a-zA-Z]+)");
            Match match = regex.Match("y=(a)(z)+AZ");

            for (int i = 0; i < match.Length; i++)
            {
                if (match.Groups[i].Value.Trim().Length > 0)
                {
                    Console.WriteLine(i + "---" + match.Groups[i].Value);

                }
            }
        }
    }
}
