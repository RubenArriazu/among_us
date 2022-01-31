## tl;dr

No hay ninguna diferencia significativa entre cerrar explicitamento
los `InputStream` y no hacerlo. Las llamadas al sistema (_system calls_) de tipo
`close` son las mismas en en caso que en otro.

## Tests

Se ha testado con Amazon Corretto 17 y con una imagen nativa generada con GraalVM
en Linux 5.15. El comando ha sido en todos los casos:

`strace -c -o resultado.txt <programa>`

### GraalVM

El resultado de cerrar los stremas de forma explicita es:

```
% time     seconds  usecs/call     calls    errors syscall
------ ----------- ----------- --------- --------- ------------------
 25.01    0.000464         464         1           execve
 24.26    0.000450          13        33           mmap
 10.24    0.000190           6        29           read
  8.89    0.000165           9        18         1 openat
  5.98    0.000111           3        31           close
  5.34    0.000099           5        18           newfstatat
  3.07    0.000057           5        10           mprotect
  2.43    0.000045           3        14           socket
  2.21    0.000041           8         5         2 connect
  1.83    0.000034           8         4           pread64
  1.08    0.000020           5         4           munmap
  1.08    0.000020           6         3           brk
  1.02    0.000019          19         1         1 access
  0.92    0.000017           2         6           prlimit64
  0.86    0.000016           8         2         1 arch_prctl
  0.75    0.000014           4         3           recvmsg
  0.65    0.000012           2         6         1 getsockname
  0.59    0.000011           1         7         2 lseek
  0.59    0.000011          11         1           sendto
  0.59    0.000011           5         2           futex
  0.54    0.000010           1         6           getsockopt
  0.38    0.000007           1         4           fstat
  0.32    0.000006           3         2           sched_getaffinity
  0.27    0.000005           1         5           rt_sigaction
  0.22    0.000004           4         1           bind
  0.16    0.000003           3         1           rt_sigprocmask
  0.16    0.000003           1         2           setsockopt
  0.16    0.000003           3         1           set_tid_address
  0.16    0.000003           3         1           getrandom
  0.11    0.000002           2         1           uname
  0.11    0.000002           2         1           set_robust_list
  0.00    0.000000           0         1           write
  0.00    0.000000           0         1           shutdown
  0.00    0.000000           0         1           socketpair
  0.00    0.000000           0         1           sysinfo
------ ----------- ----------- --------- --------- ------------------
100.00    0.001855           8       227         8 total
```

El resultado de dejar que Java se ocupe de cerrar (o no cerrar) el stream produce:

````
% time     seconds  usecs/call     calls    errors syscall
------ ----------- ----------- --------- --------- ------------------
 15.88    0.000251           8        29           read
 11.07    0.000175           5        33           mmap
 10.37    0.000164           5        31           close
  9.30    0.000147         147         1           execve
  9.17    0.000145           8        18         1 openat
  7.65    0.000121           8        14           socket
  6.01    0.000095           5        18           newfstatat
  5.25    0.000083          16         5         2 connect
  3.35    0.000053           5        10           mprotect
  2.02    0.000032           4         7         2 lseek
  1.58    0.000025           6         4           munmap
  1.58    0.000025           4         6         1 getsockname
  1.58    0.000025           4         6           getsockopt
  1.45    0.000023           3         6           prlimit64
  1.27    0.000020          20         1           write
  1.27    0.000020           4         5           rt_sigaction
  1.20    0.000019           4         4           fstat
  1.20    0.000019          19         1           socketpair
  1.08    0.000017           5         3           recvmsg
  0.89    0.000014           3         4           pread64
  0.89    0.000014          14         1           sendto
  0.76    0.000012           4         3           brk
  0.70    0.000011           5         2           setsockopt
  0.57    0.000009           4         2           futex
  0.57    0.000009           4         2           sched_getaffinity
  0.51    0.000008           8         1           shutdown
  0.44    0.000007           3         2         1 arch_prctl
  0.38    0.000006           6         1         1 access
  0.38    0.000006           6         1           bind
  0.38    0.000006           6         1           sysinfo
  0.32    0.000005           5         1           getrandom
  0.25    0.000004           4         1           uname
  0.25    0.000004           4         1           set_tid_address
  0.25    0.000004           4         1           set_robust_list
  0.19    0.000003           3         1           rt_sigprocmask
------ ----------- ----------- --------- --------- ------------------
100.00    0.001581           6       227         8 total
```

## OpenJDK 17

El resultado de cerrar los streams de forma explicita es:

```
% time     seconds  usecs/call     calls    errors syscall
------ ----------- ----------- --------- --------- ----------------
 91.92    0.010359       10359         1           futex
  2.10    0.000237           4        58        47 openat
  1.62    0.000183           5        35           mmap
  1.45    0.000163           3        47        36 newfstatat
  0.60    0.000068           4        15           read
  0.59    0.000066           5        12           mprotect
  0.36    0.000041           3        11           close
  0.23    0.000026           4         6           lseek
  0.21    0.000024           8         3           munmap
  0.14    0.000016           4         4           pread64
  0.14    0.000016          16         1           clone3
  0.09    0.000010           3         3           rt_sigprocmask
  0.08    0.000009           4         2           readlink
  0.07    0.000008           2         3           brk
  0.06    0.000007           3         2           getpid
  0.05    0.000006           6         1           stat
  0.05    0.000006           3         2         1 access
  0.04    0.000005           5         1           getrandom
  0.04    0.000004           4         1           rt_sigaction
  0.04    0.000004           2         2         1 arch_prctl
  0.04    0.000004           4         1           set_tid_address
  0.04    0.000004           4         1           set_robust_list
  0.04    0.000004           4         1           prlimit64
  0.00    0.000000           0         1           execve
------ ----------- ----------- --------- --------- ----------------
100.00    0.011270          52       214        85 total
```

El resultado de dejar que sea la JVM la que se encarge de cerrar (o no) los streams es:

```
% time     seconds  usecs/call     calls    errors syscall
------ ----------- ----------- --------- --------- ----------------
 91.38    0.006290        6290         1           futex
  2.35    0.000162           4        35           mmap
  1.15    0.000079           1        58        47 openat
  0.94    0.000065           5        12           mprotect
  0.80    0.000055           3        15           read
  0.52    0.000036           3        11           close
  0.42    0.000029           0        47        36 newfstatat
  0.38    0.000026           8         3           munmap
  0.38    0.000026          26         1           clone3
  0.33    0.000023           3         6           lseek
  0.22    0.000015           3         4           pread64
  0.19    0.000013           6         2           readlink
  0.17    0.000012           4         3           rt_sigprocmask
  0.13    0.000009           3         3           brk
  0.10    0.000007           3         2           getpid
  0.09    0.000006           6         1           stat
  0.09    0.000006           3         2         1 access
  0.07    0.000005           5         1           getrandom
  0.06    0.000004           4         1           rt_sigaction
  0.06    0.000004           2         2         1 arch_prctl
  0.06    0.000004           4         1           set_robust_list
  0.06    0.000004           4         1           prlimit64
  0.04    0.000003           3         1           set_tid_address
  0.00    0.000000           0         1           execve
------ ----------- ----------- --------- --------- ----------------
100.00    0.006883          32       214        85 total
```

## Conclusiones

El numero de veces en el que se ha llamado a la _system call_ `close` se describe
en la tabla siguiente.

Numero de `close` | GraalVM | OpenJDK17
--- | --- | ---
Stream cerrado explicitamente | 31 | 11
Cierre del stream no controlado | 31 | 11 

No soy un experto en Linux ni en las llamadas del sistema, pero estos datos parecen
demostrar que no es necesario controlar explicitamente el cierre de streams en Java 17.

