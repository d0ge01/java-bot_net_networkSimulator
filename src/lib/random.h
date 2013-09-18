#include <time.h>
#include <stdlib.h>


float 
randBetween0upto1()
{
	/*
	 * This will return value between 0.10 and 0.99
	 */
	
	float r;
	
	srand(time(NULL));
	r = rand();
	
	return r;
}