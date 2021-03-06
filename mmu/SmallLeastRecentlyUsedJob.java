package mmu;
// This is the small test case file for the Least Recently Used MMU

public class SmallLeastRecentlyUsedJob extends Job {

    public SmallLeastRecentlyUsedJob(Tester theTester) {
        super(theTester);
    }

    public void run() {
        tester.expectPageFault();
        tester.expectFillPage(4, 0);
        tester.performAccess(4189, AccessType.READ, 93);
        tester.expectPageFault();
        tester.expectFillPage(3, 1);
        tester.performAccess(3564, AccessType.READ, 1516);
        tester.performAccess(4280, AccessType.READ, 184);
        tester.expectPageFault();
        tester.expectFillPage(5, 2);
        tester.performAccess(5760, AccessType.READ, 2688);
        tester.performAccess(4851, AccessType.READ, 755);
        tester.expectPageFault();
        tester.expectFillPage(0, 3);
        tester.performAccess(764, AccessType.READ, 3836);
        tester.expectPageFault();
        tester.expectFillPage(1, 4);
        tester.performAccess(1798, AccessType.READ, 4870);
        tester.expectPageFault();
        tester.expectFillPage(2, 5);
        tester.performAccess(2886, AccessType.READ, 5958);
        tester.performAccess(794, AccessType.READ, 3866);
        tester.performAccess(2134, AccessType.READ, 5206);
        tester.performAccess(389, AccessType.READ, 3461);
        tester.performAccess(843, AccessType.READ, 3915);
        tester.performAccess(2467, AccessType.READ, 5539);
        tester.performAccess(2667, AccessType.WRITE, 5739);
        tester.performAccess(2067, AccessType.WRITE, 5139);
        tester.performAccess(3232, AccessType.READ, 1184);
        tester.performAccess(2490, AccessType.READ, 5562);
        tester.performAccess(562, AccessType.READ, 3634);
        tester.performAccess(3982, AccessType.WRITE, 1934);
        tester.performAccess(2350, AccessType.READ, 5422);
        tester.expectPageFault();
        tester.expectFillPage(18, 6);
        tester.performAccess(19166, AccessType.READ, 6878);
        tester.expectPageFault();
        tester.expectFillPage(27, 7);
        tester.performAccess(28663, AccessType.READ, 8183);
        tester.performAccess(18465, AccessType.READ, 6177);
        tester.performAccess(3879, AccessType.WRITE, 1831);
        tester.performAccess(2338, AccessType.READ, 5410);
        tester.performAccess(405, AccessType.READ, 3477);
        tester.performAccess(3996, AccessType.READ, 1948);
        tester.performAccess(28559, AccessType.READ, 8079);
        tester.performAccess(988, AccessType.READ, 4060);
        tester.performAccess(1878, AccessType.READ, 4950);
        tester.performAccess(2012, AccessType.READ, 5084);
        tester.performAccess(3678, AccessType.READ, 1630);
        tester.performAccess(2673, AccessType.WRITE, 5745);
        tester.performAccess(2933, AccessType.READ, 6005);
        tester.performAccess(19037, AccessType.READ, 6749);
        tester.performAccess(28011, AccessType.READ, 7531);
        tester.performAccess(3385, AccessType.WRITE, 1337);
        tester.performAccess(19309, AccessType.READ, 7021);
        tester.performAccess(3943, AccessType.READ, 1895);
        tester.clearRBits();
        tester.performAccess(18841, AccessType.READ, 6553);
        tester.performAccess(3238, AccessType.READ, 1190);
        tester.performAccess(3625, AccessType.READ, 1577);
        tester.performAccess(1873, AccessType.READ, 4945);
        tester.performAccess(1544, AccessType.READ, 4616);
        tester.performAccess(2385, AccessType.READ, 5457);
        tester.performAccess(18706, AccessType.READ, 6418);
        tester.performAccess(18945, AccessType.READ, 6657);
        tester.performAccess(28634, AccessType.READ, 8154);
        tester.performAccess(2398, AccessType.READ, 5470);
        tester.performAccess(19046, AccessType.READ, 6758);
        tester.performAccess(1127, AccessType.READ, 4199);
        tester.performAccess(2926, AccessType.READ, 5998);
        tester.performAccess(2340, AccessType.WRITE, 5412);
        tester.performAccess(2943, AccessType.READ, 6015);
        tester.performAccess(2212, AccessType.WRITE, 5284);
        tester.performAccess(2438, AccessType.READ, 5510);
        tester.performAccess(255, AccessType.READ, 3327);
        tester.performAccess(1904, AccessType.READ, 4976);
        tester.performAccess(3948, AccessType.WRITE, 1900);
        tester.performAccess(2003, AccessType.READ, 5075);
        tester.performAccess(3399, AccessType.READ, 1351);
        tester.performAccess(739, AccessType.READ, 3811);
        tester.performAccess(987, AccessType.READ, 4059);
        tester.performAccess(1123, AccessType.READ, 4195);
        tester.expectPageFault();
        tester.expectFillPage(25, 2);
        tester.performAccess(26332, AccessType.READ, 2780);
        tester.expectPageFault();
        tester.expectFillPage(5, 0);
        tester.performAccess(5703, AccessType.READ, 583);
        tester.performAccess(26157, AccessType.READ, 2605);
        tester.performAccess(2905, AccessType.WRITE, 5977);
        tester.performAccess(3646, AccessType.READ, 1598);
        tester.performAccess(6083, AccessType.READ, 963);
        tester.performAccess(3283, AccessType.READ, 1235);
        tester.performAccess(26499, AccessType.READ, 2947);
        tester.performAccess(25728, AccessType.READ, 2176);
        tester.performAccess(3172, AccessType.READ, 1124);
        tester.performAccess(26449, AccessType.READ, 2897);
        tester.performAccess(1748, AccessType.READ, 4820);
        tester.performAccess(1843, AccessType.READ, 4915);
        tester.performAccess(3510, AccessType.READ, 1462);
        tester.performAccess(3555, AccessType.READ, 1507);
        tester.clearRBits();
        tester.performAccess(1920, AccessType.READ, 4992);
        tester.performAccess(25738, AccessType.READ, 2186);
        tester.performAccess(2763, AccessType.WRITE, 5835);
        tester.performAccess(363, AccessType.READ, 3435);
        tester.performAccess(1983, AccessType.READ, 5055);
        tester.performAccess(1143, AccessType.READ, 4215);
        tester.performAccess(1491, AccessType.READ, 4563);
        tester.performAccess(26533, AccessType.READ, 2981);
        tester.performAccess(503, AccessType.READ, 3575);
        tester.performAccess(25660, AccessType.READ, 2108);
        tester.performAccess(1739, AccessType.READ, 4811);
        tester.performAccess(25809, AccessType.READ, 2257);
        tester.performAccess(26328, AccessType.READ, 2776);
        tester.performAccess(26129, AccessType.READ, 2577);
        tester.performAccess(3916, AccessType.WRITE, 1868);
        tester.performAccess(752, AccessType.READ, 3824);
        tester.performAccess(4013, AccessType.WRITE, 1965);
        tester.performAccess(4089, AccessType.READ, 2041);
        tester.performAccess(5829, AccessType.READ, 709);
        tester.performAccess(3938, AccessType.READ, 1890);
        tester.expectPageFault();
        tester.expectFillPage(29, 7);
        tester.performAccess(29773, AccessType.READ, 7245);
        tester.expectPageFault();
        tester.expectFillPage(4, 6);
        tester.performAccess(5045, AccessType.READ, 7093);
        tester.performAccess(2403, AccessType.READ, 5475);
        tester.performAccess(2308, AccessType.WRITE, 5380);
        tester.performAccess(3030, AccessType.WRITE, 6102);
        tester.performAccess(30188, AccessType.READ, 7660);
        tester.performAccess(2700, AccessType.READ, 5772);
        tester.performAccess(2319, AccessType.READ, 5391);
        tester.expectPageFault();
        tester.expectFillPage(26, 4);
        tester.performAccess(26885, AccessType.READ, 4357);
        tester.performAccess(29782, AccessType.READ, 7254);
        tester.performAccess(27538, AccessType.READ, 5010);
        tester.performAccess(2918, AccessType.READ, 5990);
        tester.performAccess(27055, AccessType.READ, 4527);
        tester.expectPageFault();
        tester.expectFillPage(1, 2);
        tester.performAccess(1567, AccessType.READ, 2591);
        tester.performAccess(2636, AccessType.READ, 5708);
        tester.performAccess(2160, AccessType.READ, 5232);
        tester.performAccess(1416, AccessType.READ, 2440);
        tester.performAccess(30519, AccessType.READ, 7991);
        tester.performAccess(30271, AccessType.READ, 7743);
        tester.performAccess(14, AccessType.READ, 3086);
        tester.clearRBits();
        tester.performAccess(27139, AccessType.READ, 4611);
        tester.performAccess(4896, AccessType.READ, 6944);
        tester.performAccess(4597, AccessType.READ, 6645);
        tester.performAccess(2111, AccessType.READ, 5183);
        tester.performAccess(642, AccessType.READ, 3714);
        tester.performAccess(26816, AccessType.READ, 4288);
        tester.performAccess(497, AccessType.READ, 3569);
        tester.performAccess(30232, AccessType.READ, 7704);
        tester.performAccess(30334, AccessType.READ, 7806);
        tester.performAccess(2918, AccessType.WRITE, 5990);
        tester.performAccess(4720, AccessType.WRITE, 6768);
        tester.performAccess(26652, AccessType.READ, 4124);
        tester.performAccess(628, AccessType.READ, 3700);
        tester.performAccess(1080, AccessType.READ, 2104);
        tester.performAccess(1357, AccessType.READ, 2381);
        tester.performAccess(5023, AccessType.READ, 7071);
        tester.performAccess(1795, AccessType.READ, 2819);
        tester.performAccess(30125, AccessType.READ, 7597);
        tester.performAccess(27015, AccessType.READ, 4487);
        tester.performAccess(1147, AccessType.READ, 2171);
        tester.expectPageFault();
        tester.expectFillPage(31, 0);
        tester.performAccess(32307, AccessType.READ, 563);
        tester.performAccess(1577, AccessType.READ, 2601);
        tester.performAccess(3094, AccessType.READ, 1046);
        tester.expectPageFault();
        tester.expectFlushPage(2, 5);
        tester.expectFillPage(20, 5);
        tester.performAccess(21382, AccessType.READ, 6022);
        tester.performAccess(21038, AccessType.READ, 5678);
        tester.expectPageFault();
        tester.expectFillPage(2, 3);
        tester.performAccess(2694, AccessType.WRITE, 3718);
        tester.performAccess(1209, AccessType.READ, 2233);
        tester.performAccess(3377, AccessType.WRITE, 1329);
        tester.performAccess(31813, AccessType.READ, 69);
        tester.performAccess(3092, AccessType.READ, 1044);
        tester.performAccess(1163, AccessType.READ, 2187);
        tester.expectPageFault();
        tester.expectFlushPage(4, 6);
        tester.expectFillPage(0, 6);
        tester.performAccess(654, AccessType.READ, 6798);
        tester.performAccess(3067, AccessType.WRITE, 4091);
        tester.performAccess(32257, AccessType.READ, 513);
        tester.performAccess(4094, AccessType.READ, 2046);
        tester.performAccess(2194, AccessType.READ, 3218);
        tester.performAccess(1216, AccessType.READ, 2240);
        tester.performAccess(3219, AccessType.READ, 1171);
        tester.performAccess(32183, AccessType.READ, 439);
        tester.performAccess(410, AccessType.READ, 6554);
        tester.clearRBits();
        tester.performAccess(1422, AccessType.READ, 2446);
        tester.performAccess(284, AccessType.READ, 6428);
        tester.performAccess(21143, AccessType.READ, 5783);
        tester.performAccess(2632, AccessType.WRITE, 3656);
        tester.performAccess(3162, AccessType.READ, 1114);
        tester.performAccess(32163, AccessType.READ, 419);
        tester.performAccess(765, AccessType.READ, 6909);
        tester.performAccess(465, AccessType.READ, 6609);
        tester.performAccess(21481, AccessType.READ, 6121);
        tester.performAccess(4071, AccessType.WRITE, 2023);
        tester.performAccess(31919, AccessType.READ, 175);
        tester.performAccess(20699, AccessType.READ, 5339);
        tester.performAccess(3533, AccessType.READ, 1485);
        tester.performAccess(21098, AccessType.READ, 5738);
        tester.performAccess(20833, AccessType.READ, 5473);
        tester.performAccess(3223, AccessType.WRITE, 1175);
        tester.performAccess(252, AccessType.READ, 6396);
        tester.performAccess(703, AccessType.READ, 6847);
        tester.performAccess(31888, AccessType.READ, 144);
        tester.performAccess(21099, AccessType.READ, 5739);
        tester.performAccess(1058, AccessType.READ, 2082);
        tester.performAccess(1441, AccessType.READ, 2465);
        tester.expectPageFault();
        tester.expectFillPage(7, 7);
        tester.performAccess(7305, AccessType.READ, 7305);
        tester.performAccess(267, AccessType.READ, 6411);
        tester.expectPageFault();
        tester.expectFillPage(4, 4);
        tester.performAccess(4996, AccessType.READ, 4996);
        tester.performAccess(4773, AccessType.READ, 4773);
        tester.performAccess(2637, AccessType.WRITE, 3661);
        tester.performAccess(584, AccessType.READ, 6728);
        tester.performAccess(1600, AccessType.READ, 2624);
        tester.performAccess(4373, AccessType.READ, 4373);
        tester.expectPageFault();
        tester.expectFlushPage(3, 1);
        tester.expectFillPage(12, 1);
        tester.performAccess(12369, AccessType.READ, 1105);
        tester.performAccess(4840, AccessType.READ, 4840);
        tester.performAccess(4519, AccessType.READ, 4519);
        tester.performAccess(1932, AccessType.READ, 2956);
        tester.performAccess(558, AccessType.READ, 6702);
        tester.performAccess(7176, AccessType.READ, 7176);
        tester.performAccess(2260, AccessType.READ, 3284);
        tester.performAccess(4611, AccessType.READ, 4611);
        tester.performAccess(7529, AccessType.READ, 7529);
        tester.performAccess(2216, AccessType.WRITE, 3240);
        tester.clearRBits();
        tester.performAccess(2731, AccessType.WRITE, 3755);
    }
}
