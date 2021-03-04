from bs4 import BeautifulSoup
import requests

res = requests.get('ここにURL')
soup = BeautifulSoup(res.content, "lxml", from_encoding='utf-8')


'''
name = soup.find_all('small')

for umamusume_name in  name:
  output_name = umamusume_name.text.replace('\n', '')
  print(output_name)
'''

birth = soup.find_all('strong')

for umamusume_birth in  birth:
  output_birth = umamusume_birth.text.replace('\n', '')
  print(output_birth)
