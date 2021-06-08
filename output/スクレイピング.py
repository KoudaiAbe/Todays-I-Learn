from bs4 import BeautifulSoup
import requests

res = requests.get('ここにURL')
soup = BeautifulSoup(res.content, "lxml", from_encoding='utf-8')


'''
name = soup.find_all('small')

class_を指定して要素を取得する場合
name = soup.find_all('', class_='cat')

for umamusume_name in  name:
  output_name = umamusume_name.text.replace('\n', '')
  print(output_name)
'''

birth = soup.find_all('strong')

for umamusume_birth in  birth:
  output_birth = umamusume_birth.text.replace('\n', '')
  print(output_birth)

  '''
  参考
  https://qiita.com/itkr/items/513318a9b5b92bd56185
  
  
  '''
