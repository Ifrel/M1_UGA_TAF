To compile, simply type ./configure ; make [install]

The Makefile.in and configure script were built with autoconf. The real source files are in the m4 directory, Makefile.am and configure.ac (which defines the version for instance...)

If a dependancy changes, simply change Makefile.am, and run autoreconf.

For a version change, same thing after updating configure.ac.

*******
What's good??
-> make check now works, allows to test the simple cases
-> make dist also works, that's pretty cool too!

