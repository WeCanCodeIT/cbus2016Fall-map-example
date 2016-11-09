package map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountMapGeneratorTest {

	private Collection<Account> accounts;

	@Before
	public void setup() {
		accounts = new ArrayList<>();
	}

	@Test
	public void shouldBuildAnEmptyMap() {

		AccountMapGenerator underTest = new AccountMapGenerator(accounts);

		Map<String, Account> result = underTest.generate();

		assertTrue(result.isEmpty());
	}

	@Test
	public void shouldBuildAMapWithOneElement() {

		String accountNumber = "42";
		Account account = new Account(accountNumber);
		accounts.add(account);

		AccountMapGenerator underTest = new AccountMapGenerator(accounts);

		Map<String, Account> result = underTest.generate();

		// this is how we check to see if a map contains a key
		assertTrue(result.containsKey(accountNumber));
		// this is how we check to see if a map contains a value
		assertTrue(result.containsValue(account));

		// this is how we iterate over keys
		Set<String> keys = result.keySet();
		assertEquals(accountNumber, keys.iterator().next());

		// this is how we iterate over values
		Collection<Account> values = result.values();
		assertEquals(account, values.iterator().next());

		// this is how we iterate over the entries in a map
		Set<Entry<String, Account>> entries = result.entrySet();
		Entry<String, Account> firstEntry = entries.iterator().next();
		assertEquals(accountNumber, firstEntry.getKey());
		assertEquals(account, firstEntry.getValue());

		// this is how we get a value from a map
		Account value = result.get(accountNumber);

		assertEquals(account, value);
	}
}
