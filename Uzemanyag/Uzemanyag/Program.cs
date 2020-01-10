using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Uzemanyag
{
    class Program
    {
        struct uzem
        {
           // public DateTime datum;
            public int ev;
            public int honap;
            public int nap;
            public int benzin;
            public int dizel;
        }
        static void Main(string[] args)
        {
            string[] g = File.ReadAllLines("uzemanyag.txt");
            uzem[] t = new uzem[g.Length];
/*
            for (int i = 0; i < g.Length; i++)
            {
                string[] f = g[i].Split(';');
                for (int j = 0; j < g.Length; j++)
                {
                    string[] h = g[i].Split('.');
                    t[i].ev = int.Parse(h[0]);
                    t[i].honap = int.Parse(h[1]);
                    t[i].nap = Convert.ToInt32(h[2]);
                }
                t[i].benzin = Convert.ToInt32(f[3]);
                t[i].dizel = Convert.ToInt32(f[4]);
            }
            */
            for (int i = 0; i < g.Length; i++)
            {
                string[] f = g[i].Split(';');
                t[i].ev = int.Parse(f[0].Split('.')[0]);
                t[i].honap = int.Parse(f[0].Split('.')[1]);
                t[i].nap = int.Parse(f[0].Split('.')[2]);
                t[i].benzin = int.Parse(f[1]);
                t[i].dizel = int.Parse(f[2]);
            }
            Console.WriteLine("3.feladat: Változások száma {0}", g.Length);

            int min = Math.Abs(t[0].benzin - t[0].dizel);

            for (int i = 0; i < g.Length; i++)
            {
                if (min > Math.Abs(t[i].benzin - t[i].dizel))
                {
                    min = Math.Abs(t[i].benzin - t[i].dizel);

                }
            }
            int hanyszor = 0;
            for (int i = 0; i < g.Length; i++)
            {
                if (Math.Abs(t[i].benzin - t[i].dizel) == min)
                {
                    hanyszor++;
                }
            }
            Console.WriteLine("4.feladat: A legkisseb külömbség: {0}", min);
            Console.WriteLine("5.feladat: A legkisebb külömbség előfordulása: {0}", hanyszor);

            bool volt = false;
            for (int i = 0; i < g.Length; i++)
            {
                if (t[i].ev % 4 == 0 && t[i].honap % 2 == 0/*&& t[i].nap % 24 == 0*/)
                {
                    volt = true;
                }
            }
            if (volt == true)
            {
                Console.WriteLine("Volt változás");
            }
            else
            {
                Console.WriteLine("Nem volt Változás");
            }
            StreamWriter ir = new StreamWriter("euro.txt");
            for (int i = 0; i < g.Length; i++)
            {
                ir.WriteLine("{0}.{1}.{2} {3:0.00}Euro {4:0.00}Euro",t[i].ev,t[i].honap,t[i].nap,(t[i].benzin/307.7),(t[i].dizel/307.7));
            }
            ir.Close();

            int beevszam;
            do
            {
                Console.Write("Kérem adja meg az évszámot! [2011..2016]: ");
                beevszam = Convert.ToInt32(Console.ReadLine());
            } while (beevszam <= 2011 || beevszam >= 2016);
            Console.ReadKey();
        }
    }
}
