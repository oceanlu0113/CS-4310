package mmu;
// This file holds the small test-case list of accesses.  We can run these
// jobs through the system in 'Generate' mode with a particular MMU implementation
// to build the final small test case file for that MMU.

public class Sample1Job extends Job {

    public Sample1Job(Tester theTester) {
        super(theTester);
    }

    public void run() {
        tester.performAccess(4189, AccessType.READ, 93);
        tester.performAccess(3564, AccessType.READ, 1516);
        tester.performAccess(4280, AccessType.READ, 184);
        tester.performAccess(5760, AccessType.READ, 2688);
        tester.performAccess(4851, AccessType.READ, 755);
        tester.performAccess(764, AccessType.READ, 3836);
        tester.performAccess(1798, AccessType.READ, 4870);
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
        tester.performAccess(19166, AccessType.READ, 6878);
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
        tester.performAccess(26332, AccessType.READ, 732);
        tester.performAccess(5703, AccessType.READ, 2631);
        tester.performAccess(26157, AccessType.READ, 557);
        tester.performAccess(2905, AccessType.WRITE, 5977);
        tester.performAccess(3646, AccessType.READ, 1598);
        tester.performAccess(6083, AccessType.READ, 3011);
        tester.performAccess(3283, AccessType.READ, 1235);
        tester.performAccess(26499, AccessType.READ, 899);
        tester.performAccess(25728, AccessType.READ, 128);
        tester.performAccess(3172, AccessType.READ, 1124);
        tester.performAccess(26449, AccessType.READ, 849);
        tester.performAccess(1748, AccessType.READ, 4820);
        tester.performAccess(1843, AccessType.READ, 4915);
        tester.performAccess(3510, AccessType.READ, 1462);
        tester.performAccess(3555, AccessType.READ, 1507);
        tester.clearRBits();
        tester.performAccess(1920, AccessType.READ, 4992);
        tester.performAccess(25738, AccessType.READ, 138);
        tester.performAccess(2763, AccessType.WRITE, 5835);
        tester.performAccess(363, AccessType.READ, 3435);
        tester.performAccess(1983, AccessType.READ, 5055);
        tester.performAccess(1143, AccessType.READ, 4215);
        tester.performAccess(1491, AccessType.READ, 4563);
        tester.performAccess(26533, AccessType.READ, 933);
        tester.performAccess(503, AccessType.READ, 3575);
        tester.performAccess(25660, AccessType.READ, 60);
        tester.performAccess(1739, AccessType.READ, 4811);
        tester.performAccess(25809, AccessType.READ, 209);
        tester.performAccess(26328, AccessType.READ, 728);
        tester.performAccess(26129, AccessType.READ, 529);
        tester.performAccess(3916, AccessType.WRITE, 1868);
        tester.performAccess(752, AccessType.READ, 3824);
        tester.performAccess(4013, AccessType.WRITE, 1965);
        tester.performAccess(4089, AccessType.READ, 2041);
        tester.performAccess(5829, AccessType.READ, 2757);
        tester.performAccess(3938, AccessType.READ, 1890);
        tester.performAccess(29773, AccessType.READ, 1101);
        tester.performAccess(5045, AccessType.READ, 2997);
        tester.performAccess(2403, AccessType.READ, 5475);
        tester.performAccess(2308, AccessType.WRITE, 5380);
        tester.performAccess(3030, AccessType.WRITE, 6102);
        tester.performAccess(30188, AccessType.READ, 1516);
        tester.performAccess(2700, AccessType.READ, 5772);
        tester.performAccess(2319, AccessType.READ, 5391);
        tester.performAccess(26885, AccessType.READ, 3333);
        tester.performAccess(29782, AccessType.READ, 1110);
        tester.performAccess(27538, AccessType.READ, 3986);
        tester.performAccess(2918, AccessType.READ, 5990);
        tester.performAccess(27055, AccessType.READ, 3503);
        tester.performAccess(1567, AccessType.READ, 4639);
        tester.performAccess(2636, AccessType.READ, 5708);
        tester.performAccess(2160, AccessType.READ, 5232);
        tester.performAccess(1416, AccessType.READ, 4488);
        tester.performAccess(30519, AccessType.READ, 1847);
        tester.performAccess(30271, AccessType.READ, 1599);
        tester.performAccess(14, AccessType.READ, 4110);
        tester.clearRBits();
        tester.performAccess(27139, AccessType.READ, 3587);
        tester.performAccess(4896, AccessType.READ, 2848);
        tester.performAccess(4597, AccessType.READ, 2549);
        tester.performAccess(2111, AccessType.READ, 5183);
        tester.performAccess(642, AccessType.READ, 4738);
        tester.performAccess(26816, AccessType.READ, 3264);
        tester.performAccess(497, AccessType.READ, 4593);
        tester.performAccess(30232, AccessType.READ, 1560);
        tester.performAccess(30334, AccessType.READ, 1662);
        tester.performAccess(2918, AccessType.WRITE, 5990);
        tester.performAccess(4720, AccessType.WRITE, 2672);
        tester.performAccess(26652, AccessType.READ, 3100);
        tester.performAccess(628, AccessType.READ, 4724);
        tester.performAccess(1080, AccessType.READ, 5176);
        tester.performAccess(1357, AccessType.READ, 5453);
        tester.performAccess(5023, AccessType.READ, 2975);
        tester.performAccess(1795, AccessType.READ, 5891);
        tester.performAccess(30125, AccessType.READ, 1453);
        tester.performAccess(27015, AccessType.READ, 3463);
        tester.performAccess(1147, AccessType.READ, 5243);
        tester.performAccess(32307, AccessType.READ, 6707);
        tester.performAccess(1577, AccessType.READ, 5673);
        tester.performAccess(3094, AccessType.READ, 7190);
        tester.performAccess(21382, AccessType.READ, 902);
        tester.performAccess(21038, AccessType.READ, 558);
        tester.performAccess(2694, AccessType.WRITE, 1670);
        tester.performAccess(1209, AccessType.READ, 5305);
        tester.performAccess(3377, AccessType.WRITE, 7473);
        tester.performAccess(31813, AccessType.READ, 6213);
        tester.performAccess(3092, AccessType.READ, 7188);
        tester.performAccess(1163, AccessType.READ, 5259);
        tester.performAccess(654, AccessType.READ, 4750);
        tester.performAccess(3067, AccessType.WRITE, 2043);
        tester.performAccess(32257, AccessType.READ, 6657);
        tester.performAccess(4094, AccessType.READ, 8190);
        tester.performAccess(2194, AccessType.READ, 1170);
        tester.performAccess(1216, AccessType.READ, 5312);
        tester.performAccess(3219, AccessType.READ, 7315);
        tester.performAccess(32183, AccessType.READ, 6583);
        tester.performAccess(410, AccessType.READ, 4506);
        tester.clearRBits();
        tester.performAccess(1422, AccessType.READ, 5518);
        tester.performAccess(284, AccessType.READ, 4380);
        tester.performAccess(21143, AccessType.READ, 663);
        tester.performAccess(2632, AccessType.WRITE, 1608);
        tester.performAccess(3162, AccessType.READ, 7258);
        tester.performAccess(32163, AccessType.READ, 6563);
        tester.performAccess(765, AccessType.READ, 4861);
        tester.performAccess(465, AccessType.READ, 4561);
        tester.performAccess(21481, AccessType.READ, 1001);
        tester.performAccess(4071, AccessType.WRITE, 8167);
        tester.performAccess(31919, AccessType.READ, 6319);
        tester.performAccess(20699, AccessType.READ, 219);
        tester.performAccess(3533, AccessType.READ, 7629);
        tester.performAccess(21098, AccessType.READ, 618);
        tester.performAccess(20833, AccessType.READ, 353);
        tester.performAccess(3223, AccessType.WRITE, 7319);
        tester.performAccess(252, AccessType.READ, 4348);
        tester.performAccess(703, AccessType.READ, 4799);
        tester.performAccess(31888, AccessType.READ, 6288);
        tester.performAccess(21099, AccessType.READ, 619);
        tester.performAccess(1058, AccessType.READ, 5154);
        tester.performAccess(1441, AccessType.READ, 5537);
        tester.performAccess(7305, AccessType.READ, 2185);
        tester.performAccess(267, AccessType.READ, 4363);
        tester.performAccess(4996, AccessType.READ, 3972);
        tester.performAccess(4773, AccessType.READ, 3749);
        tester.performAccess(2637, AccessType.WRITE, 1613);
        tester.performAccess(584, AccessType.READ, 4680);
        tester.performAccess(1600, AccessType.READ, 5696);
        tester.performAccess(4373, AccessType.READ, 3349);
        tester.performAccess(12369, AccessType.READ, 4177);
        tester.performAccess(4840, AccessType.READ, 3816);
        tester.performAccess(4519, AccessType.READ, 3495);
        tester.performAccess(1932, AccessType.READ, 6028);
        tester.performAccess(558, AccessType.READ, 5678);
        tester.performAccess(7176, AccessType.READ, 2056);
        tester.performAccess(2260, AccessType.READ, 1236);
        tester.performAccess(4611, AccessType.READ, 3587);
        tester.performAccess(7529, AccessType.READ, 2409);
        tester.performAccess(2216, AccessType.WRITE, 1192);
        tester.clearRBits();
        tester.performAccess(2731, AccessType.WRITE, 1707);
    }
}
