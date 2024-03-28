from flask import Flask, jsonify, request, json
from flask_mysqldb import MySQL
from flask_cors import CORS

app = Flask(__name__)
CORS(app)
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = ''
app.config['MYSQL_DB'] = 'dec2023'

mysql = MySQL(app)

@app.route("/")
def getDbData():
      cursor = mysql.connection.cursor()
      cursor.execute("select name,email from user")
      result = cursor.fetchall()
      data = [];
      for row in result:
            data.append({"name":row[0],"email":row[1]})
      return jsonify(data);

if __name__ == '__main__':
   app.run()