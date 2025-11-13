Fess Ingest Example
[![Java CI with Maven](https://github.com/codelibs/fess-ingest-example/actions/workflows/maven.yml/badge.svg)](https://github.com/codelibs/fess-ingest-example/actions/workflows/maven.yml)
==========================

## Overview

Fess Ingest Exampleは、Fessのインジェスト機能を拡張するためのサンプルプロジェクトです。
このプロジェクトは、カスタムインジェスターを作成する方法を示すテンプレートとして使用できます。

このサンプル実装では、クロールされたデータをログに出力します。
以下の2種類のクロール結果を処理します：

- データストアクロール（データベース、CSVファイルなど）
- Web/ファイルクロール（Webサイト、ファイルシステム）

## Download

See [Maven Repository](https://repo1.maven.org/maven2/org/codelibs/fess/fess-ingest-example/).

## Installation

See [Plugin](https://fess.codelibs.org/13.7/admin/plugin-guide.html) of Administration guide.

## Usage

このプロジェクトをベースに、独自のインジェスターを作成できます：

1. `ExampleIngester`クラスを参考にして、独自の処理ロジックを実装
2. データの変換、フィルタリング、エンリッチメント、外部システムへの転送などが可能
3. `fess_ingest++.xml`で DIコンポーネントとして登録

## Development

### Build

```bash
mvn clean package
```

### Test

```bash
mvn test
```
