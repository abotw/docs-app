
## 1. 配置 Anki

1. 安装 [AnkiConnect](https://ankiweb.net/shared/info/2055492159)
	- Tools > Add-ons (⇧⌘A) > Get Add-ons... > Code: 2055492159 > OK
2. 配置 AnkiConnect
	- 选中AnkiConnect > Config > 添加 `"app://obsidian.md"` > OK

```json
{
    "apiKey": null,
    "apiLogPath": null,
    "ignoreOriginList": [],
    "webBindAddress": "127.0.0.1",
    "webBindPort": 8765,
    "webCorsOriginList": [
        "http://localhost",
        "app://obsidian.md"
    ]
}
```

3. 重启Anki
4. 新增 Note Type 并添加新字段（链接、上下文）
	- Tools > Manage Note Types (⇧⌘N) > Add > Add: Basic > `Basic: Obsidian` > Fields > Add > `Obsidian Link` > OK > Add > `Obsidian Context` > OK > Save
5. 调整 flashcard 的显示
	- Cards > Back Template > Save

```html
{{FrontSide}}

<hr id=answer>

{{Back}}

<br><br>
<p style="font-size: 10px;">{{Obsidian Link}} | {{Obsidian Context}}</p>
```

## 2. 配置 Obsidian

1. 安装 [Export to Anki](obsidian://show-plugin?id=obsidian-to-anki-plugin)
	- Install > Enable
2. 配置 Export to Anki
	- Options
		- Note Type Settings
			- Note Type
			- Custom Regexp
				- Basic: `((?:[^\n][\n]?)+) #fc ?\n*((?:\n(?:^.{1,3}$|^.{4}(?<!<!--).*))+)`
				- Cloze: `((?:[^\n][\n]?)+) #cc ?\n*((?:\n(?:^.{1,3}$|^.{4}(?<!<!--).*))+)`
			- File Link Field: `Obsidian Link`
			- Context Field: `Obsidian Context`
		- Folder Setting
		- Syntax Settings
		- Defaults
			- Add File Link: On
			- Add Context: On
			- ID Comments: On
		- Actions
		- Ignored File Settings

## 3. 使用示例

## ClozeCard格式

- 注意：`#clozecard`標籤後方一定要換行，下一行要有任何文字或符號，之後再空行分開段落
- 單純{}產生cloze，有幾個就幾張卡片
- 加上編號{1: } {2: }的話，同一編號的出現在同一張卡片
- 提示文字：加在雙冒號之後 {答案::提示}

### 範例

```
- 他住在{1:倫敦::城市名稱}的{1:貝克街::街道名稱}，興趣是{2:拉小提琴::樂器} #clozecard 
- Sherlock Holmes
```

## Ref

- 參考資料：[官方documentation](https://github.com/ObsidianToAnki/Obsidian_to_Anki/wiki)
	- [regex](https://github.com/ObsidianToAnki/Obsidian_to_Anki/wiki/Regex)