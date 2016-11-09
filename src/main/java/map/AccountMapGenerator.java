package map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AccountMapGenerator {

	private final Collection<Account> accounts;

	public AccountMapGenerator(Collection<Account> accounts) {
		this.accounts = Collections.unmodifiableCollection(accounts);
		
	}

	public Map<String, Account> generate() {
		Map<String, Account> map = new HashMap<String, Account>();
		for (Account current : accounts) {
			String key = current.getAccountNumber();
			map.put(key, current);
		}
		return map;
	}

}
