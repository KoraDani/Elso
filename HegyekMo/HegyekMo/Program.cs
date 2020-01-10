using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace HegyekMo
{
    class Program
    {
        struct hegyek {
            public string hegycsucs;
            public string hegyseg;
            public int magassag;

        }
        static void Main(string[] args)
        {
            int atlagmag = 0;
            int index = 0;
            int hegyszam=0;
            string[] a = File.ReadAllLines("hegyekMo.txt"); 
            hegyek[] t = new hegyek[a.Length];
            for (int i = 1; i < a.Length; i++)
            {
                string[] g = a[i].Split(';');
                t[i-1].hegycsucs = g[0];
                t[i-1].hegyseg = g[1];
                t[i-1].magassag = Convert.ToInt32(g[2]);
                atlagmag += t[i].magassag;
                // Console.WriteLine("{0} {1} {2}", t[i].hegycsucs, t[i].hegyseg, t[i].magassag);

            }
            Array.Sort(t, (y, x) => x.magassag.CompareTo(y.magassag));
            Console.WriteLine("3. feladat: Hegycsúcsok száma: {0}",a.Length-1);
            Console.WriteLine("4. feladat: Hegycsúcsok átlagos magassága {0}", atlagmag/(a.Length-1));
            Console.WriteLine("5. feladat: A legmagasabb hegcsúcs adatai: \n{0}\n{1}\n{2}", t[a.Length-1].hegycsucs, t[a.Length-1].hegyseg, t[a.Length-1].magassag);
            /*Console.Write("6. feladat: Kérek egy magasságot:");
            int szam = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < a.Length; i++)
            {
                if (t[i].hegyseg == "Börzsöny" && t[i].magassag > szam)
                {
                    index = i;
                }
                else {
                    index = 0;
                }

            }
            if (index != 0)
            {
                Console.WriteLine("Van {0}m magasabb hegység a Börzsönyben", szam);
            }
            else
            {
                Console.WriteLine("Nincs {0}m magasabb hegység a börzsönyben", szam);
            }*/
            for (int i = 0; i < a.Length; i++)
            {
                if (t[i].magassag > 914)
                {
                    hegyszam++;
                }
            }
            Console.WriteLine("7. feladat: 3000 lábnál magasabb hegycsúcsok száma {0}", hegyszam);
            Console.ReadKey();
        }
    }
}
