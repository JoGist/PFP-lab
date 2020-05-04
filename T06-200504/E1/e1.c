#include "e1.h"
#include <immintrin.h>

// ---------------------------------------------------------------------
// matmul
// ---------------------------------------------------------------------
// SSE version

static void add_prod(const short *src, short *dst, short x, int n)
{
    int j;
    __m128i a, b, mul, sum;
    a = _mm_set1_epi16(x);
    sum = _mm_setzero_si128();
    for (j = 0; j + 7 < n; j += 8)
    {
        b = _mm_loadu_si128((const __m128i *)(src + j));
        sum = _mm_loadu_si128((const __m128i *)(dst + j));
        mul = _mm_mullo_epi16(a, b);
        sum = _mm_add_epi16(sum, mul);
        _mm_storeu_si128((__m128i *)(dst + j), sum);
    }
    for (; j < n; j++)
        dst[j] += src[j] * x;
}

void matmul(const short **a, const short **b, short **c, int n)
{
    int i, j, k;
    for (i = 0; i < n; ++i)
        for (j = 0; j < n; ++j)
            c[i][j] = 0;
    for (i = 0; i < n; ++i)
        for (k = 0; k < n; ++k)
            add_prod(b[k], c[i], a[i][k], n);
}

// ---------------------------------------------------------------------
// matmul_seq
// ---------------------------------------------------------------------
// sequential version

static void add_prod_seq(const short *src, short *dst, short x, int n)
{
    int j;
    for (j = 0; j < n; ++j)
        dst[j] += x * src[j];
}

void matmul_seq(const short **a, const short **b, short **c, int n)
{
    int i, j, k;
    for (i = 0; i < n; ++i)
        for (j = 0; j < n; ++j)
            c[i][j] = 0;
    for (i = 0; i < n; ++i)
        for (k = 0; k < n; ++k)
            add_prod_seq(b[k], c[i], a[i][k], n);
}
