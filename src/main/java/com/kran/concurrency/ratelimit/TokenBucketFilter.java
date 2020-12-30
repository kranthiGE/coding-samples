package com.kran.concurrency.ratelimit;

public class TokenBucketFilter {
	
	private int MAX_TOKENS;
	private long lastRequestTime = System.currentTimeMillis();
	private long possible_tokens;
	
	public TokenBucketFilter(int maxTokens) {
		this.MAX_TOKENS = maxTokens;
	}
	
	public synchronized void getToken() throws InterruptedException {
		/* calculate the generation of token based on last request time to current and maximum allowed tokens that can be generated and buffered.
		 * assume MAX_TOKENS = 5 then 5 tokens are generated in 5 seconds
		 * if last request time - current > 5 seconds then 
		 *   token generation has to sleep for a second so that a new token can be generated and returned.
		 * if last request time - current < 5 seconds then
		 *   return possible_tokens = current - last_request_time (suppose 3 seconds = 3 tokens)
		 */
		possible_tokens = (System.currentTimeMillis() - lastRequestTime)/1000; // in seconds
		if(possible_tokens > MAX_TOKENS) { // generate only MAX_TOKENS if time crosses max limit
			possible_tokens = MAX_TOKENS;
		}
		
		if(possible_tokens == 0) {
			Thread.sleep(1000);
		}
		else {
			possible_tokens--;
		}
		lastRequestTime = System.currentTimeMillis();
		System.out.println(
                "Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1000));
	}

}
