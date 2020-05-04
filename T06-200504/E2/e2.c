#include <immintrin.h>
#include "e2.h"

// ---------------------------------------------------------------------
// count_occ
// ---------------------------------------------------------------------
// SSE version

int count_occ(const char *v, int n, char x)
{
    int i, c = 0;
    unsigned char mc[16];
    __m128i div, res, vc, vx;
    vc = _mm_setzero_si128();
    vx = _mm_set1_epi8(x);
    for (i = 0; i + 15 < n; i += 16)
    {
        div = _mm_loadu_si128((const __m128i *)(v + i));
        res = _mm_cmpeq_epi8(div, vx);
        vc = _mm_sub_epi8(vc, res);
        if (i % 255 == 0)
        {
            int j;
            _mm_storeu_si128((__m128i *)mc, vc);
            for (j = 0; j < 16; j++)
            {
                c += mc[j];
            }
            vc = _mm_setzero_si128();
        }
    }
    for (; i < n; i++)
    {
        if (v[i] == x)
        {
            c++;
        }
    }
    _mm_storeu_si128((__m128i *)mc, vc);
    for (i = 0; i < 16; i++)
    {
        c += mc[i];
    }
    return c;
}

// ---------------------------------------------------------------------
// count_occ_seq
// ---------------------------------------------------------------------
// sequential version

int count_occ_seq(const char *v, int n, char x)
{
    int i, cnt = 0;
    for (i = 0; i < n; ++i)
        cnt += v[i] == x;
    return cnt;
}
