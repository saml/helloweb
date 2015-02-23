package servlets

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.Unpooled
import io.netty.channel.socket.SocketChannel
import io.netty.channel.{ChannelFutureListener, ChannelInitializer, ChannelHandlerContext, ChannelHandlerAdapter}
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http._


class HelloWorldHandler extends ChannelHandlerAdapter {
  val content = "Hello world".getBytes


  override def channelReadComplete(ctx: ChannelHandlerContext) = {
    ctx.flush()
  }

  override def channelRead(ctx: ChannelHandlerContext, msg: Object) = {
    if (msg.isInstanceOf[HttpRequest]) {
//      val req = msg.asInstanceOf[HttpRequest]
//      if (HttpHeaders.is100ContinueExpected(req)) {
//        ctx.write(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE))
//      }


      val resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(content))
      val headers = resp.headers()
      headers.set(HttpHeaders.Names.CONTENT_LENGTH, content.length)
      ctx.write(resp)

//      if (HttpHeaders.isKeepAlive(req)) {
//        ctx.write(resp).addListener(ChannelFutureListener.CLOSE)
//      } else {
//        headers.set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE)
//        ctx.write(resp)
//      }
    }
  }

  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) = {
    cause.printStackTrace()
    ctx.close()
  }
}

class HelloWorldInitializer extends ChannelInitializer[SocketChannel] {
  override def initChannel(ch: SocketChannel) = {
    val pipeline = ch.pipeline()
    pipeline.addLast(new HttpServerCodec())
    pipeline.addLast(new HelloWorldHandler())
  }
}

object Main extends App {
  override def main(args: Array[String]): Unit = {
    val bossGroup = new NioEventLoopGroup(1)
    val workerGroup = new NioEventLoopGroup()
    try {
      val bootstrap = new ServerBootstrap()
      bootstrap.group(bossGroup, workerGroup)
        .channel(classOf[NioServerSocketChannel])
        .childHandler(new HelloWorldInitializer())

      val port = 8080
      val chan = bootstrap.bind(port).sync().channel()
      println(s"http://localhost:${port}")
      chan.closeFuture().sync()

    } finally {
      bossGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }
  }
}

// vim: set ts=4 sw=4 et:
