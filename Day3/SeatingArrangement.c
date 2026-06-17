#include <stdio.h>
void solve() {
    int n, m;
    scanf("%d %d", &n, &m); 
    int tot = n * m;
    int a[tot];
    
    for (int i = 0; i < tot; i++) {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < tot - 1; i++) {
        for (int j = 0; j < tot - i - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
    
    int inc = 0;
    for (int i = 0; i < tot; i++) {
        for (int j = 0; j < i; j++) {
            if (a[j] < a[i]) {
                inc++;
            }
        }
    }
    printf("%d\n", inc);
}
int main() {
    int t;
    printf("enter t:");
    scanf("%d", &t);
    while (t--) solve();
    return 0;
}
