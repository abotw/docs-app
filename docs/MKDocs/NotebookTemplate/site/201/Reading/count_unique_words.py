import sys
import re

def count_unique_words(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        text = f.read().lower()
    # 用正则匹配单词（字母数字下划线）
    words = re.findall(r'\b\w+\b', text)
    unique_words = set(words)
    print(len(unique_words))

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print("Usage: python count_unique_words.py <file.txt>")
        sys.exit(1)
    count_unique_words(sys.argv[1])
