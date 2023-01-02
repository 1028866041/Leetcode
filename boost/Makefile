cc = g++
prom = boost
deps = *.h
src = *.cpp
obj = $(src:%.c=%.o)

$(prom): $(obj)
	$(cc) -o $(prom) $(obj)
	$(prom)
%.o: %.c $(deps)
	$(cc) -c $< -o $@
clean:
	rm -rf $(obj) $(prom)